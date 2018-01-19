package br.com.santander.devguide.rdbms.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class MyEntityDao {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public MyEntityDao() {

	}

	public MyEntityBean save(MyEntityBean entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public MyEntityBean find(long id) {
		return em.find(MyEntityBean.class, id);
	}

	public MyDataBean retrieveData(long id) {
		String sql = "SELECT ID matricula, TEXT descricao, MOMENT dataHora, AMOUNT valorTotal FROM MY_ENTITY_TB WHERE id = ?";

		RowMapper<MyDataBean> rowMapper = new BeanPropertyRowMapper<MyDataBean>(MyDataBean.class);

		MyDataBean dados = jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);

		return dados;
	}
}
