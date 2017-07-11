package com.maizhong.auction.controller;

import com.maizhong.auction.pojo.CkUser;
import com.maizhong.auction.pojo.SysCompany;
import com.maizhong.auction.pojo.SysMenu;
import com.maizhong.auction.pojo.SysUser;
import com.maizhong.auction.service.CheckService;
import com.maizhong.auction.service.IndexService;
import com.maizhong.auction.service.SystemService;
import com.maizhong.common.dto.PageSearchParam;
import com.maizhong.common.result.JsonResult;
import com.maizhong.common.utils.JsonUtils;
import net.sf.json.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Xushd on 2017/7/4.
 */
@Controller
public class SystemController {

    @Autowired
    private IndexService indexService;
    @Autowired
    private CheckService checkService;

    @Autowired
    private SystemService systemService;
    /**
     * 系统用户
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/account")
    public String accountIndex(Model model, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("cur","/system/account");
        model.addAttribute("username",username);

        return "views/sys_account";

    }

    /**
     * 获取用户列表数据
     * @return
     */
    @RequestMapping(value = "/system/account/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult accountList(PageSearchParam param){
        JsonResult result = systemService.getSysAccountList(param);
        return result;
    }

    /**
     * 用户保存或更新
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/account/save")
    @ResponseBody
    public JsonResult accountSave(SysUser user,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = systemService.saveSysAccount(user,token);
        return result;
    }

    /**
     * 用户修改状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/system/account/status/{id}/{status}")
    @ResponseBody
    public JsonResult accountStatus(@PathVariable long id,@PathVariable int status){
        JsonResult result = systemService.statusSysAccount(id,status);
        return result;
    }

    /**
     * 用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/account/del/{id}")
    @ResponseBody
    public JsonResult accountDelete(@PathVariable long id){
        JsonResult result = systemService.delSysAccount(id);
        return result;
    }

    /**
     * 检测端用户
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/check/account")
    public String checkAccountIndex(Model model,HttpServletRequest request){

        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("cur","/system/check/account");
        model.addAttribute("username",username);

        JsonResult result = systemService.getCompanyListAll();
        model.addAttribute("companys", JsonUtils.objectToJson(result.getData()));

        return "/views/check_account";
    }

    /**
     * 获取检测用户列表数据
     * @return
     */
    @RequestMapping(value = "/system/check/account/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult checkAccountList(PageSearchParam param){
        JsonResult result = systemService.getCheckAccountList(param);
        return result;
    }

    /**
     * 检测用户保存或更新
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/check/account/save")
    @ResponseBody
    public JsonResult checkAccountSave(CkUser user, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = systemService.saveCheckAccount(user,token);
        return result;
    }

    /**
     * 检测用户修改状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/system/check/account/status/{id}/{status}")
    @ResponseBody
    public JsonResult checkAccountStatus(@PathVariable long id,@PathVariable int status){
        JsonResult result = systemService.statusCheckAccount(id,status);
        return result;
    }

    /**
     * 检测用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/check/account/del/{id}")
    @ResponseBody
    public JsonResult checkAccountDelete(@PathVariable long id){
        JsonResult result = systemService.delSCheckAccount(id);
        return result;
    }


    /**
     * 商户管理
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/company")
    public String companyIndex(Model model,HttpServletRequest request){

        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("cur","/system/company");
        model.addAttribute("username",username);


        return "/views/sys_company";
    }

    /**
     * 获取商户列表数据
     * @return
     */
    @RequestMapping(value = "/system/company/list",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult companyList(PageSearchParam param){
        JsonResult result = systemService.getCompanyList(param);
        return result;
    }

    /**
     * 检测用户保存或更新
     * @param company
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/company/save")
    @ResponseBody
    public JsonResult companySave(SysCompany company, HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = systemService.saveCompany(company,token);
        return result;
    }

    /**
     * 检测用户修改状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping(value = "/system/company/status/{id}/{status}")
    @ResponseBody
    public JsonResult companyStatus(@PathVariable long id,@PathVariable int status){
        JsonResult result = systemService.statusCompany(id,status);
        return result;
    }

    /**
     * 检测用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/company/del/{id}")
    @ResponseBody
    public JsonResult companyDelete(@PathVariable long id){
        JsonResult result = systemService.delCompany(id);
        return result;
    }

    /**
     * 车辆审核
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/check/examine")
    public String examineIndex(Model model,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("cur","/system/check/examine");
        model.addAttribute("username",username);

        return "/views/sys_examine";
    }

    /**
     * 获取审核车辆
     * @param param
     * @return
     */
    @RequestMapping(value = "/system/check/examine/list")
    @ResponseBody
    public JsonResult examineList(PageSearchParam param){
        JsonResult result = systemService.getExamineCarList(param);
        return result;
    }

    /**
     * 审核通过
     * @param id
     * @return
     */
    @RequestMapping(value = "/system/check/examine/pass/{id}")
    @ResponseBody
    public JsonResult examinePass(@PathVariable long id,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = systemService.examinePass(id,token);
        return result;
    }

    /**
     * 审核驳回
     * @param id
     * @param reason
     * @param request
     * @return
     */
    @RequestMapping(value = "/system/check/examine/reject/{id}")
    @ResponseBody
    public JsonResult examineReject(@PathVariable long id,String reason,HttpServletRequest request){
        String token = (String) request.getAttribute("token");
        JsonResult result = systemService.examineReject(id,reason,token);
        return result;
    }

    /**
     * 获取检测车辆STEP1信息 （xsz,djz,qtz,czxx）
     * @param carId
     * @return
     */
    @RequestMapping(value = "/system/check/car/step1/{carId}")
    @ResponseBody
    public JsonResult checkCarSTEP1(@PathVariable long carId){
        JsonResult result = checkService.getCarStep1(carId);
        return result;
    }
    /**
     * 获取检测车辆STEP2信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/system/check/car/step2/{carId}")
    @ResponseBody
    public JsonResult checkCarSTEP2(@PathVariable long carId){
        JsonResult result = checkService.getCarBaseImg(carId);
        return result;
    }
    /**
     * 获取检测车辆STEP3信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/system/check/car/step3/{carId}")
    @ResponseBody
    public JsonResult checkCarSTEP3(@PathVariable long carId){
        JsonResult result = checkService.getCarStep3(carId);
        return result;
    }
    /**
     * 获取检测车辆STEP4信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/system/check/car/step4/{carId}")
    @ResponseBody
    public JsonResult checkCarSTEP4(@PathVariable long carId){
        JsonResult result = checkService.getCarStep4(carId);
        return result;
    }
    /**
     * 获取检测车辆STEP5信息
     * @param carId
     * @return
     */
    @RequestMapping(value = "/system/check/car/step5/{carId}")
    @ResponseBody
    public JsonResult checkCarSTEP5(@PathVariable long carId){
        JsonResult result = checkService.getCarStep5(carId);
        return result;
    }

    /**
     * 代拍车辆
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/system/check/wait")
    public String checkCarWait(HttpServletRequest request,Model model){
        String token = (String) request.getAttribute("token");
        String username = (String) request.getAttribute("username");

        String sysMenuJson = indexService.getSystemMenu(token);
        model.addAttribute("menu",sysMenuJson);
        model.addAttribute("cur","/system/check/wait");
        model.addAttribute("username",username);

        return "/views/sys_wait";
    }
    /**
     * 获取待拍车辆
     * @param param
     * @return
     */
    @RequestMapping(value = "/system/check/wait/list")
    @ResponseBody
    public JsonResult waitList(PageSearchParam param){
        JsonResult result = systemService.getWaitCarList(param);
        return result;
    }
}
