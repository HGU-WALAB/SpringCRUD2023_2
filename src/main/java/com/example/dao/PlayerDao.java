package com.example.dao;

import com.example.vo.PlayerVo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerDao {

    SqlSession sqlSession;

    @Autowired
    public PlayerDao(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertPlayer(PlayerVo vo){
        return sqlSession.insert("Player.insertPlayer", vo);
    }

    public int deletePlayer(int id){
        return sqlSession.delete("Player.deletePlayer", id);
    }

    public int updatePlayer(PlayerVo vo){
        return sqlSession.update("Player.updatePlayer", vo);
    }

    public PlayerVo getPlayer(int id){
        return sqlSession.selectOne("Player.getPlayer", id);
    }

    public List<PlayerVo> getPlayerList(){
        return sqlSession.selectList("Player.getPlayerList");
    }

    public String getImage(int id){
        return sqlSession.selectOne("Player.getImage", id);
    }
//    private final String PLAYER_INSERT="insert into PLAYER (name,weight,height,image,birthday,formation,pass,shoot,defense,speed,intelligence,goalkeeping) values (?,?,?,?,?,?,?,?,?,?,?,?)";
//    private final String PLAYER_UPDATE = "update PLAYER set name=?, weight=?, height=?, image=?, birthday=?, formation=?, pass=?, shoot=?, defense=?, speed=?, intelligence=?, goalkeeping=?, modDate=current_timestamp where id=?";
//    private final String PLAYER_DELETE="delete from PLAYER where id=?";
//
//    private final String PLAYER_GET = "select * from PLAYER where id=?";
//
//    private final String PLAYER_LIST="select * from PLAYER order by id desc";

//    @Autowired
//    private JdbcTemplate template;

//    public void setTemplate(JdbcTemplate template) {
//        this.template = template;
//    }
//
//    public int insertPlayer(PlayerVo vo){
//        return template.update(PLAYER_INSERT,new Object[]{vo.getName(),vo.getWeight(),vo.getHeight(),vo.getImage(),vo.getBirthday(),vo.getFormation(),vo.getPass(),vo.getShoot(),vo.getDefense(),vo.getSpeed(),vo.getIntelligence(),vo.getGoalkeeping()});
//    }
//
//    public int deletePlayer(int id){
//        return template.update(PLAYER_DELETE,
//                new Object[]{id});
//    }
//
//    public int updatePlayer(PlayerVo vo){
//        return template.update(PLAYER_UPDATE,
//                new Object[]{vo.getName(),vo.getWeight(),vo.getHeight(),vo.getImage(),vo.getBirthday(),vo.getFormation(),vo.getPass(),vo.getShoot(),vo.getDefense(),vo.getSpeed(),vo.getIntelligence(),vo.getGoalkeeping(),vo.getId()});
//    }
//
//    public PlayerVo getPlayer(int id){
//        return template.queryForObject(PLAYER_GET,
//                new Object[]{id},
//                new BeanPropertyRowMapper<PlayerVo>(PlayerVo.class));
//    }
//
//    public List<PlayerVo> getPlayerList(){
//        return template.query(PLAYER_LIST, new RowMapper<PlayerVo>() {
//            @Override
//            public PlayerVo mapRow(ResultSet rs, int rowNum) throws SQLException {
//                PlayerVo data=new PlayerVo();
//                data.setId(rs.getInt("id"));
//                data.setName(rs.getString("name"));
//                data.setWeight(rs.getInt("weight"));
//                data.setHeight(rs.getInt("height"));
//                data.setImage(rs.getString("image"));
//                data.setBirthday(rs.getDate("birthday"));
//                data.setFormation(rs.getString("formation"));
//                data.setPass(rs.getInt("pass"));
//                data.setShoot(rs.getInt("shoot"));
//                data.setDefense(rs.getInt("defense"));
//                data.setSpeed(rs.getInt("speed"));
//                data.setIntelligence(rs.getInt("intelligence"));
//                data.setGoalkeeping(rs.getInt("goalkeeping"));
//                return data;
//            }
//        });
//    }
//
//    public String getImage(int id){
//        return template.queryForObject("select image from PLAYER where id=?",
//                new Object[]{id},
//                String.class);
//    }
}

//*****  임연규 바보  ******
