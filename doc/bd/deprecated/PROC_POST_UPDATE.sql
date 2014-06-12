CREATE OR REPLACE PROCEDURE PROC_POST_UPDATE (
  p_id            IN  POST.ID_POST%TYPE,
  p_titulo        IN  POST.TITULO_POST%TYPE,
  p_datacriacao   IN  POST.DATACRIACAO_POST%TYPE,
  p_conteudo      IN  POST.CONTEUDO_POST%TYPE,
  p_usuario_id    IN  POST.ID_USUARIO%TYPE
) 
  IS
  BEGIN
    UPDATE POST 
    SET ID_POST=p_id,
        TITULO_POST=p_titulo,
        DATACRIACAO_POST=p_datacriacao,
        CONTEUDO_POST=p_conteudo,
        ID_USUARIO=p_usuario_id
        WHERE (POST.ID_POST = p_id);
    COMMIT;
  END PROC_POST_UPDATE;