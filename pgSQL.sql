CREATE OR REPLACE PROCEDURE deletaCliente(valor INT) AS $$
DECLARE
    id_endereco INT;
BEGIN
    -- Atribui o valor retornado pela consulta à variável
    SELECT idendereco INTO id_endereco FROM pessoa WHERE idpessoa = valor;
    
    DELETE FROM cliente WHERE idpessoa = valor;
    DELETE FROM pessoa WHERE idpessoa = valor;
    DELETE FROM endereco WHERE idendereco = id_endereco;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE PROCEDURE deletaFuncionario(valor INT) AS $$
DECLARE
    id_endereco INT;
BEGIN
    -- Atribui o valor retornado pela consulta à variável
    SELECT idendereco INTO id_endereco FROM pessoa WHERE idpessoa = valor;
    
    DELETE FROM funcionario WHERE idpessoa = valor;
    DELETE FROM pessoa WHERE idpessoa = valor;
    DELETE FROM endereco WHERE idendereco = id_endereco;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE deletaFornecedor(valor INT) AS $$
DECLARE
    id_endereco INT;
BEGIN
    -- Atribui o valor retornado pela consulta à variável
    SELECT idendereco INTO id_endereco FROM fornecedor WHERE idfornecedor = valor;
    
    DELETE FROM fornecedor WHERE idfornecedor = valor;
    DELETE FROM endereco WHERE idendereco = id_endereco;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE deletaRelatorioServico(valor INT) AS $$
DECLARE
    id_veiculo INT;
BEGIN
    -- Atribui o valor retornado pela consulta à variável
    SELECT v.idVeiculo INTO id_veiculo FROM veiculo v
		JOIN cliente_servico cs ON cs.idveiculo = v.idveiculo
		WHERE cs.idservico = valor;
	
	DELETE FROM servico_funcionario WHERE idservico = valor;
	DELETE FROM produtos_servico WHERE idservico = valor;
	DELETE FROM cliente_servico WHERE idservico = valor;
	DELETE FROM veiculo WHERE idveiculo = id_veiculo;
    	DELETE FROM servico WHERE idservico = valor;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE PROCEDURE deletaProduto(valor INT) AS $$
DECLARE
    id_fornecedorProduto INT;
BEGIN
    -- Atribui o valor retornado pela consulta à variável
    SELECT idfornecedor_produto INTO id_fornecedorProduto from fornecedor_produtos where idproduto = valor;
    
    DELETE FROM fornecedor_produtos WHERE idfornecedor_produto = id_fornecedorProduto;
    DELETE FROM produtos WHERE idproduto = valor;
END;
$$ LANGUAGE plpgsql;
