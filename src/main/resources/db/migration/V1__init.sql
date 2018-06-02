CREATE TABLE hospede(
id bigserial primary key,
nome varchar(50) NOT NULL,
documento varchar(15) NOT NULL,
telefone varchar(15) NOT NULL); 

CREATE TABLE checkin(
id bigserial primary key,
hospede_id bigint NOT NULL,
data_entrada timestamp without time zone NOT NULL,
data_saida timestamp without time zone NOT NULL,
adicional_veiculo boolean NOT NULL,
CONSTRAINT fk_checkin_hospede FOREIGN KEY (hospede_id) REFERENCES hospede (id)); 