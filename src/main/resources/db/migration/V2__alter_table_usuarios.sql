-- Adiciona coluna perfil_id na tabela usuarios
ALTER TABLE usuarios
ADD COLUMN perfil_id BIGINT;

-- Cria a constraint de FK para perfis
ALTER TABLE usuarios
ADD CONSTRAINT fk_usuario_perfil
FOREIGN KEY (perfil_id) REFERENCES perfis(id);

-- Remove a tabela de junção N:N, se existir
DROP TABLE IF EXISTS usuario_perfis;
