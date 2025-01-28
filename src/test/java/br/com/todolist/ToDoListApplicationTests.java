package br.com.todolist;

import br.com.todolist.Model.PriorityRole;
import br.com.todolist.Model.TodosModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToDoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void todosTestSuccess() {
		var todos = new TodosModel("Teste 1", "Teste descrição 1", PriorityRole.LOW, false);

		webTestClient
				.post()
				.uri("/todoslist/todos")
				.bodyValue(todos)
				.exchange()
				.expectStatus().isCreated()
				.expectBody()
				.jsonPath("$.name").isEqualTo(todos.getName())
				.jsonPath("$.description").isEqualTo(todos.getDescription())
				.jsonPath("$.priority").isEqualTo(todos.getPriority())
				.jsonPath("$.completed").isEqualTo(Optional.of(todos.isCompleted()));
	}

	@Test
	void todosTestFailure() {
		webTestClient
				.post()
				.uri("/todoslist/todos")
				.bodyValue(
						new TodosModel("", "", PriorityRole.HIGH, false)
				).exchange()
				.expectStatus().isBadRequest();
	}

}
