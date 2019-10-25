package com.Spring.bill.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
* bill_auth
* @author 王洋
*/
@Controller
@RequestMapping(value = "/user")
public class BillController {

    @Autowired
    private BillService billAuthService;

    /**
    * [新增]
    **/
    @RequestMapping("/insert")
    public String insert(Bill billAuth,HttpServletRequest request){
    	Principal principal = request.getUserPrincipal();
        int id = billAuthService.selectByName(principal.getName()).getId();
        billAuth.setUserId(id);
        billAuthService.insert(billAuth);
        return "redirect:list";
    }

    /**
    * [刪除]
    **/
    @RequestMapping("/delete")
    public String delete(int id){
        billAuthService.delete(id);
        return "redirect:list";
    }

    /**
    * [更新]
    **/
    @RequestMapping("/update")
    public String update(Bill billAuth){
        billAuthService.update(billAuth);
        /*billAuth.getUserId()*/
        return "redirect:list";
    }
    
    @RequestMapping("/edit")
    public String listCategory(int id,Model m) throws Exception {
    	
        Bill bill= billAuthService.selectByBillid(id);
        m.addAttribute("bill", bill);
        return "edit";
    }

    /**
    * [查詢] 用户 id 查詢
    **/
    @RequestMapping("/load")
    public List<Bill> load(int id,Model model){
        
        return billAuthService.load(id);
    }

    @RequestMapping("/list")
    public String listCategory(HttpServletRequest request,Model model) throws Exception {
    	Principal principal = request.getUserPrincipal();
        int id = billAuthService.selectByName(principal.getName()).getId();
        List<Bill> bills =billAuthService.load(id);
        
        model.addAttribute("id", id);
        model.addAttribute("accounts", bills);
        
        return "list";
    }
    
}
