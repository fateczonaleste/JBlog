CREATE OR REPLACE PROCEDURE PROC_USUARIO_UPDATE (  
  p_id  IN  USUARIO.ID_USUARIO%TYPE,
  p_nome IN USUARIO.NOME_USUARIO%TYPE, 
  p_login IN USUARIO.LOGIN_USUARIO%TYPE,
  p_senha IN USUARIO.SENHA_USUARIO%TYPE,
  p_bio IN USUARIO.BIO_USUARIO%TYPE  
) 
  IS
  BEGIN
    UPDATE USUARIO 
    SET ID_USUARIO=p_id,
        NOME_USUARIO=p_nome,
        LOGIN_USUARIO=p_login,
        SENHA_USUARIO=p_senha,
        BIO_USUARIO=p_bio
        WHERE (USUARIO.ID_USUARIO = p_id);
    COMMIT;
  END PROC_USUARIO_UPDATE;