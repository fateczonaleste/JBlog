import static org.junit.Assert.fail;

import org.junit.Test;

import br.jblog.dao.DAOBlog;
import br.jblog.dao.DAOBlogImpl;
import br.jblog.model.Blog;


public class DAOBlogTest {

	@Test
	public void testAdd() {
		
		Blog b = new Blog();
		b.setTitulo("Carina blog");
		b.setDescricao("Carina blog descrição");
		
		DAOBlog d = new DAOBlogImpl();
		
		
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testListAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetById() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}
