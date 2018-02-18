package com.cubas.bancodopovo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cubas.bancodopovo.model.Correntista;
import com.cubas.bancodopovo.repository.CorrentistaRepository;

import static org.hamcrest.Matchers.is;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.http.MediaType;
import org.junit.Before;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BancodopovoApplicationTests {
	
	@Autowired
	CorrentistaRepository correntistaRepository;
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;
	
	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	@Test
	public void buscaCorrentistasCadastrados() {
		
		Page<Correntista> correntistas = this.correntistaRepository.findAll(new PageRequest(0, 10));
		assertThat(correntistas.getTotalElements()).isGreaterThan(1L);
		
	}
	
	@Test
	public void buscaCorrentistasJoao() {
		
		Correntista correntistaNaoEncontrado = this.correntistaRepository.findByNome("José");
		assertThat(correntistaNaoEncontrado).isNull();
		
		Correntista correntistaEncontrado = this.correntistaRepository.findByNome("maria");
		assertThat(correntistaEncontrado).isNotNull();
		assertThat(correntistaEncontrado.getNome()).isEqualTo("maria");
		assertThat(correntistaEncontrado.getEmail()).isEqualTo("maria@email.com.br");
		
	}
	
	@Test
	public void testHistoricoRest() throws Exception {
		
		this.mvc.perform(post("/historico/addhistorico")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"valor\": 300.0,\"tipo\": \"C\",\"descricao\": \"pagamento de salário\",\"idConta\": 1 }")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("\"pagamento de salário\"")));
	}
	
	@Test
	public void saldoInicialConta() throws Exception {
		
		this.mvc.perform(post("/historico/addhistorico")
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"valor\": 300.0,\"tipo\": \"C\",\"descricao\": \"pagamento de salário\",\"idConta\": 1 }")
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("valorTotal", is(3000.0)))
				.andExpect(jsonPath("historicos", is(3000.0)))
				.andExpect(content().string(containsString("\"pagamento de salário\"")));
	}
	
}