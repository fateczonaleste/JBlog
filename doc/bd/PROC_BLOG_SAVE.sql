CREATE OR REPLACE PROCEDURE PROC_BLOG_SAVE
BEGIN
  UPDATE BLOG
    SET TITULO_BLOG = in_val1,
        val2 = in_val2
    WHERE val3 = in_val3;

  IF ( sql%rowcount = 0 )
      THEN
      INSERT INTO tablename
          VALUES (in_val1, in_val2, in_val3);
  END IF;
END;