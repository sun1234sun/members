package dao;

import emtity.Membersinfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yyx on 2019-01-15.
 */
public class Membersinfodao extends BaseDao {
    public List<Membersinfo> selectAll() {
        List<Membersinfo> list=new ArrayList<>();
        String sql="select mid,mname,mgender,mage,maddress,memail from membersinfo";
        getConn();
        try {
            pata=conn.prepareStatement(sql);
            rs=pata.executeQuery();
            while (rs.next()){
                Membersinfo membersinfo=new Membersinfo();
                membersinfo.setMid(rs.getInt("mid"));
                membersinfo.setMname(rs.getString("mname"));
                membersinfo.setMgender(rs.getString("mgender"));
                membersinfo.setMemail(rs.getString("memail"));
                membersinfo.setMage(rs.getInt("mage"));
                membersinfo.setMaddress(rs.getString("maddress"));
                list.add(membersinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

    }
    public Membersinfo selectId(int id){
        Membersinfo membersinfo=new Membersinfo();
        String sql="select mid,mname,mgender,mage,maddress,memail from membersinfo where mid=?";
        getConn();
        try {
            pata=conn.prepareStatement(sql);
            pata.setInt(1,id);
            rs=pata.executeQuery();
            while (rs.next()){

                membersinfo.setMid(rs.getInt("mid"));
                membersinfo.setMname(rs.getString("mname"));
                membersinfo.setMgender(rs.getString("mgender"));
                membersinfo.setMemail(rs.getString("memail"));
                membersinfo.setMage(rs.getInt("mage"));
                membersinfo.setMaddress(rs.getString("maddress"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return membersinfo;

    }
    public int update(Membersinfo m){
        String sql="update membersinfo set mname=?,mgender=?,mage=?,maddress=?,memail=? where mid=?";
        Object[] objs={
                m.getMname(),
                m.getMgender(),
                m.getMage(),
                m.getMaddress(),
                m.getMemail(),
                m.getMid()
        };
        return executeUpdate(sql,objs);
    }
}
