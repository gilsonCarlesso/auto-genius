-- Criação da tabela Endereço
create table if not exists Endereco(idEndereco serial not null,
					 Rua varchar(100),
					 Numero int,
					 Complemento varchar(30),
					 Bairro varchar(60),
					 Cidade varchar(60),
					 Estado char(2),
					 CEP varchar(9),
					 primary key (idEndereco));
					 
-- Criação da tabela Estoque
create table if not exists Estoque(idEstoque serial not null,
					LocalArmazenamento varchar(60),
					primary key (idEstoque));

-- Criação da tabela Pessoa
create table if not exists Pessoa(idPessoa serial not null,
				   Nome varchar(100) not null,
				   CPF_RG varchar(14),
				   DataNascimento varchar(10),
				   telefone varchar(14),
				   Celular varchar(14),
				   email varchar(100),
				   idEndereco int references Endereco(idEndereco),
				   primary key (idPessoa));

-- Criação da tabela Cliente				   
create table if not exists Cliente(idCliente serial not null,
					NumeroRegistroCliente int unique,
					Empresa varchar(100),
					Profissao varchar(60),
					idPessoa int,
					primary key (idCliente),
					foreign key (idPessoa) references Pessoa(idPessoa));
					
-- Criação da tabela Funcionario
create table if not exists Funcionario(idFuncionario serial not null,
						NumeroRegistroFuncionario int unique,
						Cargo varchar(60),
						Salario decimal(10,2),
						DataAdmissao varchar(10),
						Login varchar(100),
						senha varchar(200),
						idPessoa int,
						primary key (idFuncionario),
						foreign key (idPessoa) references Pessoa(idPessoa));
						
-- Criação da tabela Veiculo
create table if not exists Veiculo(idVeiculo serial not null,
					Placa varchar(8),
					Marca varchar(60),
					Nome varchar(60),
					Ano int,
					Modelo varchar(30),
					Cor varchar(30),
					idCliente int,
					primary key (idVeiculo));
					
-- Criação da tabela Fornecedor
create table if not exists Fornecedor(idFornecedor serial not null,
					   Nome varchar(100),
					   CNPJ varchar(18),
					   Email varchar(100),
					   Telefone varchar(13),
					   celular varchar(14),
					   idEndereco int,
					   primary key (idFornecedor),
					   foreign key (idEndereco) references Endereco(idEndereco));
					   
-- Criação da tabela Produtos
create table if not exists Produtos(idProduto serial not null,
					 NomeProduto varchar(100) not null,
					 NumeroProduto int unique,
					 Descricao varchar(100),
					 Marca varchar(45),
					 PrecoCompra decimal(10,2),
					 PrecoVenda decimal(10,2),
					 QuantidadeEstoque int,
					 QuantidadeEstoqueMinimo int,
					 Categoria varchar(60),
					 LocalArmazenamento varchar(60),
					 idEstoque int references Estoque(idEstoque),
					 primary key (idProduto));
					 
-- Criação da tabela Forncedor Produtos
create table if not exists Fornecedor_Produtos(idFornecedor_Produto serial not null,
								idFornecedor int references Fornecedor(idFornecedor),
								idProduto int references Produtos(idProduto));
								
-- Criação da tabela Servico
create table if not exists Servico(idServico serial not null,
					Descricao varchar,
					Preco decimal(10,2),
					Data varchar(10),
					Hora varchar(10),
					FormaPagamento varchar(15),
					TipoPagamento varchar(10),
					CondicaoPagamento varchar(10),
					Situacao varchar(10),
					primary key (idServico));
					
-- Criação da tabela Produtos Servico
create table if not exists Produtos_Servico(idProdutos_Servico serial not null,
							 idProduto int references Produtos(idProduto),
							 idServico int references Servico(idServico),
							 QuantidadeRequerida int,
							 primary key (idProdutos_Servico));
							 
-- Criação da tabela Cliente Servico
create table if not exists  Cliente_Servico(idCliente_Servico serial not null,
							 idCliente int references Cliente(idCliente),
							 idServico int references Servico(idServico),
							 idVeiculo int references Veiculo(idVeiculo),
							 primary key (idCliente_Servico));
							 
-- Criação da tabela Servico Funcionario
create table if not exists Servico_Funcionario(idServico_Funcionario serial not null,
								idServico int references Servico(idServico),
								idFuncionario int references Funcionario(idFuncionario),
								primary key (idServico));
