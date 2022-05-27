package cn.dcy.yygh.cmn.service;


import cn.dcy.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface DictService extends IService<Dict> {
    List<Dict> findChildData(Long id);

    void exportDictData(HttpServletResponse response);

    void importDictData(MultipartFile file);

    String getDictName(String dictCode, String value);

    //根据dictCode获取下级节点
    List<Dict> findByDictCode(String dictCode);
}
