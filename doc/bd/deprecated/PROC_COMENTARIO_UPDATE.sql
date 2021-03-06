CREATE OR REPLACE PROCEDURE PROC_COMENTARIO_UPDATE (
  p_id in COMENTARIO.ID_COMENTARIO%TYPE,
  p_datacriacao in COMENTARIO.DATACRIACAO_COMENTARIO%TYPE,
  p_conteudo in COMENTARIO.CONTEUDO_COMENTARIO%TYPE,
  p_nome in COMENTARIO.NOME_COMENTARIO%TYPE,
  p_email in COMENTARIO.EMAIL_COMENTARIO%TYPE,
  p_post_id in COMENTARIO.ID_POST%TYPE  
) 
  IS
  BEGIN
    UPDATE COMENTARIO 
    SET ID_COMENTARIO=p_id,
        DATACRIACAO_COMENTARIO=p_datacriacao,
        CONTEUDO_COMENTARIO=p_conteudo,
        NOME_COMENTARIO=p_nome,
        EMAIL_COMENTARIO=p_email,
        ID_POST=p_post_id
        WHERE (COMENTARIO.ID_COMENTARIO = p_id);
    COMMIT;
  END PROC_COMENTARIO_UPDATE;