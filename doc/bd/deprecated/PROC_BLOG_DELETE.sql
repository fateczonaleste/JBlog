CREATE OR REPLACE PROCEDURE PROC_BLOG_DELETE (
  p_id    IN BLOG.ID_BLOG%TYPE
  ) 
  IS
  BEGIN
    DELETE FROM BLOG
    WHERE (BLOG.ID_BLOG = p_id);
    COMMIT;    
  END PROC_BLOG_DELETE;