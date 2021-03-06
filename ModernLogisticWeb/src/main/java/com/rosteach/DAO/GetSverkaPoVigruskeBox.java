package com.rosteach.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.rosteach.entities.ReestrForaVeres;

public class GetSverkaPoVigruskeBox {
private JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	public GetSverkaPoVigruskeBox(DataSource dataSource){
		this.jdbcTemplate = (new JdbcTemplate(dataSource));
	}
	
	public List<ReestrForaVeres> getData(java.sql.Date startDate, java.sql.Date endDate){
		
		final String query = "select docdate,regnumber,clientsname,clientadresslocation,comment1,foundation,mainsumm "+
				  "from SPROUTCOMEINVOICE (820,Null,'"+
				  startDate+"','"+endDate+"',0,0, Null,0,0)";
	
		List<ReestrForaVeres> reestr= this.jdbcTemplate.query(query, new RowMapper<ReestrForaVeres>(){
			public ReestrForaVeres mapRow(ResultSet resultSet, int rowNum) throws SQLException{
				ReestrForaVeres rfv = new ReestrForaVeres();
				rfv.setRegnumber(resultSet.getString("regnumber"));
				rfv.setClientsName(resultSet.getString("clientsName"));
				rfv.setClientadresslocation(resultSet.getString("clientadresslocation"));
				rfv.setComment1(resultSet.getString("comment1"));
				rfv.setFoundation(resultSet.getString("foundation"));
				rfv.setMainsumm(resultSet.getDouble("mainsumm"));
				return rfv;
			} 
		});
		return reestr;
	}
}
