package com.zj.upms.server.controller.manage;

import com.zj.common.base.BaseController;
import com.zj.common.util.StringUtil;
import com.zj.upms.dao.model.UpmsCompany;
import com.zj.upms.dao.model.UpmsCompanyExample;
import com.zj.upms.rpc.api.UpmsCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * describe:公司管理
 *
 * @author zj
 * @date 2019/01/29
 */
@Controller
@Api(value = "公司管理", description = "公司管理")
@RequestMapping("/manage/upmsCompany")
public class UpmsCompanyController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UpmsLogController.class);

    @Autowired
    private UpmsCompanyService upmsCompanyService;


    @ApiOperation(value = "公司管理首页")
    @RequiresPermissions("upms:upmsCompany:read")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "/manage/upmsCompany/index.jsp";
    }

    @ApiOperation(value = "公司列表")
    @RequiresPermissions("upms:upmsCompany:read")
    @ResponseBody
    @RequestMapping("list")
    public Object list(@RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
                       @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
                       @RequestParam(required = false, defaultValue = "", value = "search") String search,
                       @RequestParam(required = false, value = "sort") String sort,
                       @RequestParam(required = false, value = "order") String order) throws Exception {
        UpmsCompanyExample upmsCompanyExample = new UpmsCompanyExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            upmsCompanyExample.setOrderByClause(StringUtil.humpToLine(sort) + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            upmsCompanyExample.or()
                    .andDescriptionLike("%" + search + "%");
        }
        List<UpmsCompany> rows = upmsCompanyService.selectByExampleForOffsetPage(upmsCompanyExample, offset, limit);
        long total = upmsCompanyService.countByExample(upmsCompanyExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
}
