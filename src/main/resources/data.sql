insert into Correntista (id, nome, email) values
	(1,'joao','joao@email.com.br'),
	(2,'maria','maria@email.com.br'),
	(3,'manuel','manuel@email.com.br');
	
insert into Conta (id, saldo, tipo_conta, id_correntista) values
	(1,3000.0,1,1),
	(2,5000.0,2,2),
	(3,6000.0,1,3);
	
insert into Historico (id, valor, tipo, descricao, id_conta) values
	(1,3000.0,'C','padaria',1),
	(2,5000.0,'D','mercado',1),
	(3,6000.0,'D','aluguel',1);