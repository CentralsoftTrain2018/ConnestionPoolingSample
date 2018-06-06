package servise;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import bean.KaiinLineBean;
import bean.ListOutBean;
import bean.RegistBean;
import bean.SerchBean;
import dao.Dao;
import dao.KaiinManager;
import domain.SexEnum;
import vo.KaiinVo;

public class KaiinServise {

    KaiinManager mgr = new KaiinManager();
//会員検索
    public SerchBean getSerch(int Id) {

        SerchBean sb = new SerchBean();
        try (Connection con = Dao.getConnection();) {

            KaiinVo kv = mgr.searchKaiin(Id, con);

            sb.setKaiinId(kv.getKaiinno());
            sb.setKaiinName(kv.getName());
            sb.setSex(kv.getSex());
            sb.setTourokubi(kv.getRegistdate());

        } catch ( SQLException e) {

            e.printStackTrace();
        }
        return sb;

    }
  //会員登録
    public RegistBean setKaiin(int id, String name, SexEnum sex) {

        RegistBean rb = new RegistBean();
        try (Connection con = Dao.getConnection();) {

            KaiinVo kv = mgr.registKaiin(id, name, sex, con);

            rb.setKaiinId(kv.getKaiinno());
            rb.setKaiinName(kv.getName());
            rb.setSex(kv.getSex());
            rb.setTourokubi(kv.getRegistdate());

        } catch ( SQLException e) {

            e.printStackTrace();
        }
        return rb;
    }

  //会員一覧
    public ListOutBean allKaiinList() {

        ListOutBean lob = new ListOutBean();

        try (Connection con = Dao.getConnection();) {

            Collection<KaiinVo> kvList = mgr.allKaiin(con);

            List<KaiinLineBean> list =new  ArrayList<KaiinLineBean>();

            for(KaiinVo kv: kvList) {
                KaiinLineBean klb = new KaiinLineBean();

                klb.setKaiinId(kv.getKaiinno());
                klb.setKaiinName(kv.getName());
                klb.setSex(kv.getSex());
                klb.setTourokubi(kv.getRegistdate());
                list.add(klb);
            }
            lob.setList(list);

        } catch ( SQLException e) {

            e.printStackTrace();
        }
        return lob;
    }
}
