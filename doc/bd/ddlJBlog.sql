-- LIMPEZA
DROP TABLE COMENTARIO;
DROP TABLE POST;
DROP TABLE BLOG;
DROP TABLE USUARIO;

-- USUARIO
CREATE TABLE USUARIO
(
	ID_USUARIO           INTEGER NOT NULL ,
	NOME_USUARIO         VARCHAR2(30) NULL ,
	LOGIN_USUARIO        VARCHAR2(20) NULL ,
	SENHA_USUARIO        VARCHAR2(20) NULL ,
	BIO_USUARIO          VARCHAR2(180) NULL 
);

CREATE UNIQUE INDEX XPKUSUARIO ON USUARIO
(ID_USUARIO   ASC);

CREATE UNIQUE INDEX XLOGIN_USUARIO ON USUARIO
(LOGIN_USUARIO ASC);

ALTER TABLE USUARIO
	ADD CONSTRAINT  XPKUSUARIO PRIMARY KEY (ID_USUARIO);

-- BLOG
CREATE TABLE BLOG
(
	TITULO_BLOG          VARCHAR2(30) NULL ,
	ID_BLOG              INTEGER NOT NULL ,
	DESCRICAO_BLOG       VARCHAR2(180) NULL	
);

CREATE UNIQUE INDEX XPKBLOG ON BLOG
(ID_BLOG   ASC);

ALTER TABLE BLOG
	ADD CONSTRAINT  XPKBLOG PRIMARY KEY (ID_BLOG);

-- POST
CREATE TABLE POST
(
	ID_POST              INTEGER NOT NULL ,
	TITULO_POST          VARCHAR2(40) NULL ,
	DATACRIACAO_POST     DATE NULL ,
	CONTEUDO_POST        CLOB NULL ,	
	ID_USUARIO           INTEGER NOT NULL	 
);

CREATE UNIQUE INDEX XPKPOST ON POST
(ID_POST   ASC);

ALTER TABLE POST
	ADD CONSTRAINT  XPKPOST PRIMARY KEY (ID_POST);
  
ALTER TABLE POST
	ADD (CONSTRAINT post_usuario FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO (ID_USUARIO));

-- COMENTARIO
CREATE TABLE COMENTARIO
(
	ID_COMENTARIO        INTEGER NOT NULL ,
	DATACRIACAO_COMENTARIO DATE NULL ,	  
	CONTEUDO_COMENTARIO       VARCHAR2(180) NOT NULL,	
	NOME_COMENTARIO       VARCHAR2(30) NOT NULL,
	EMAIL_COMENTARIO       VARCHAR2(40) NOT NULL,		
	ID_POST              INTEGER NOT NULL	
);

CREATE UNIQUE INDEX XPKCOMENTARIO ON COMENTARIO
(ID_COMENTARIO   ASC);

ALTER TABLE COMENTARIO
	ADD CONSTRAINT  XPKCOMENTARIO PRIMARY KEY (ID_COMENTARIO);
  
ALTER TABLE COMENTARIO
	ADD (CONSTRAINT COMENTARIO_POST FOREIGN KEY (ID_POST) REFERENCES POST (ID_POST));