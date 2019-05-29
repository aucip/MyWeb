package www.web1.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import www.web1.javaBean.Comment;
import www.web1.javaBean.Draft;
import www.web1.javaBean.Essay;
import www.web1.javaBean.News;
import www.web1.javaBean.NewsCon;
import www.web1.javaBean.NewsCon2;
import www.web1.javaBean.User;
import www.web1.javaBean.UserRel;
import www.web1.mapper.EssayDraftMapper;
import www.web1.mapper.OtherMapper;
import www.web1.mapper.UserMapper;
import www.web1.utils.Page;

@Controller
@SessionAttributes("user")
public class EDController {
	@Autowired
	EssayDraftMapper edm;
	@Autowired
	UserMapper um;
	@Autowired
	OtherMapper om;
	
	@RequestMapping("ed-content")
	public ModelAndView displayContent(@RequestParam("pid") int pid){
		ModelAndView mav = new ModelAndView();
		Essay essay = edm.eGetByPid(pid);
		List<Comment> comment = om.getByEssayPid(pid);
		if(essay != null){
			mav.addObject("essay", essay);
			mav.addObject("comment", comment);
			mav.setViewName("ed-content");
		}else{
			mav.setViewName("login");
		}
		return mav;
	}
	
	@PostMapping("subComment")
	public ModelAndView subComment(@RequestParam("content") String content,
			@RequestParam("ID") String ID,
			@RequestParam("essayPid") String essayPid){
		ModelAndView mav = new ModelAndView();
		Comment comment = new Comment(1, Integer.valueOf(essayPid), Integer.valueOf(ID), content);
		om.insertComment(comment);
		mav.setViewName("redirect:/ed-content?pid="+essayPid);
		return mav;
	}
	
	@RequestMapping("ed-index") 
	public ModelAndView getQuestions(@SessionAttribute("user") User user,
			Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 5);
		String[] typeName = {"小说","随笔","散文","作文","日记","知识"};
		List<Essay> essays = null;
		essays = edm.getEssayByType(typeName[page.getType()]);
		int total = (int) new PageInfo<>(essays).getTotal();
		page.caculateLast(total);
		
		List<Essay> essaysTop6 = edm.getEssaysTop6();
		List<Essay> essaysTop62 = edm.getEssaysTop62();
		essaysTop6 = essaysTop6.subList(0, 6);
		essaysTop62 = essaysTop62.subList(0, 6);
		
		if(user != null){
			System.out.println(user.toString());
			List<Essay> essaysFan = edm.getByFanID(user.getID());
			mav.addObject("essaysFan", essaysFan);
		}else{
			mav.addObject("essaysFan", null);
		}

		mav.addObject("essays", essays);
		mav.addObject("essaysTop62", essaysTop62);
		mav.addObject("essaysTop6", essaysTop6);
		mav.addObject("total", total/5);
		mav.setViewName("ed-index");
		return mav;
	}
	
	@RequestMapping("ed-person")
	public ModelAndView displayPerson(@SessionAttribute(value="user") User user,
			Page page){
		ModelAndView mav = new ModelAndView();
		PageHelper.offsetPage(page.getStart(), 5);
		List essays = edm.getEssayByID(user.getID());
		System.out.println(essays.size());
		int total = (int) new PageInfo<>(essays).getTotal();
		page.caculateLast(total);
		mav.addObject("total", total/5);
		mav.addObject("essays", essays);
		mav.setViewName("ed-person");
		return mav;
	}
	
	@RequestMapping("ed-userUI")
	public ModelAndView displayUserUI(@SessionAttribute("user") User user,
			@RequestParam("ID") int ID){
		ModelAndView mav = new ModelAndView();
		User person = um.getByID(ID);
		List<UserRel> res = um.getByFanID(user.getID());
		UserRel re = null;
		for(int i = 0; i < res.size(); i++){
			if(res.get(i).getID() == ID){
				re =res.get(i);
				break;
			}
		}
		List<Essay> essays = edm.getEssayByID(ID);
		mav.addObject("re", re);
		mav.addObject("person", person);
		mav.addObject("essays", essays);
		mav.setViewName("ed-userUI");
		return mav;
	}	
	
	@RequestMapping("concern")
	public ModelAndView concern(@SessionAttribute("user") User user,
			@RequestParam("ID") int ID){
		ModelAndView mav = new ModelAndView();
		UserRel r = new UserRel(ID, user.getID());
		um.addUserRel(r);
		mav.setViewName("redirect:/ed-userUI?ID="+String.valueOf(ID));
		return mav;
	}
	
	@RequestMapping("unconcern")
	public ModelAndView unconcern(@SessionAttribute("user") User user,
			@RequestParam("ID") int ID){
		ModelAndView mav = new ModelAndView();
		UserRel r = new UserRel(ID, user.getID());
		um.deleteUserRel(r);
		mav.setViewName("redirect:/ed-userUI?ID="+String.valueOf(ID));
		return mav;
	}
	
	@RequestMapping("ed-upload")
	public ModelAndView displayUpload(@SessionAttribute(value="user") User user,@RequestParam(value="pid",defaultValue="0") int pid){
		ModelAndView mav = new ModelAndView();
		List drafts = edm.getDraftByID(user.getID());
		Draft draft = null;
		for(int i = 0; i < drafts.size(); i++){
			Draft d = (Draft) drafts.get(i);
			if(d.getPid() == pid){
				draft = d;
			}
		}
		mav.addObject("drafts", drafts);
		mav.addObject("draft", draft);
		mav.setViewName("ed-upload");
		return mav;
	}
	
	@RequestMapping("ed-news")
	public ModelAndView displayNews(@SessionAttribute(value="user") User user){
		ModelAndView mav = new ModelAndView();
		List<User> people = om.getNewsList(user.getID());
		mav.addObject("people", people);
		mav.setViewName("ed-news");
		return mav;
	}
	
	@RequestMapping("ed-newsFrame")
	public ModelAndView displayNewsFrame(@SessionAttribute(value="user") User user,@RequestParam(value="id",defaultValue="0") int id){
		ModelAndView mav = new ModelAndView();
		List<NewsCon> meNewsCons = om.getUsersNews(user.getID(), id);
		List<NewsCon> newsCons = om.getUsersNews(id, user.getID());
		NewsCon2 newsConAll = null;
		try {
			newsConAll = new NewsCon2(meNewsCons, newsCons);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.addObject("news", newsConAll);
		mav.addObject("userb", id);
		mav.setViewName("ed-newsFrame");
		return mav;
	}
	
	@PostMapping("subNews")
	public ModelAndView subNews(@RequestParam("usera") int usera,
			@RequestParam("userb") int userb, 
			@RequestParam("text") String text){
		ModelAndView mav = new ModelAndView();
		om.addNews(usera, userb, text);
		mav.setViewName("login");
		return mav;
	}
	
	@PostMapping("/subHeadPic")
	public String subHeadPic(@SessionAttribute(value="user") User user,
			HttpServletRequest request,
			@RequestParam("file") MultipartFile file,
			Model model) throws Exception{
		if(!file.isEmpty()){
			String path = request.getServletContext().getRealPath("/headImage");
			String name = file.getOriginalFilename();
			String filename = String.valueOf(user.getID())+"."+name.substring(name.length()-3, name.length());
			File filepath = new File(path, filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			file.transferTo(new File(path + File.separator + filename));
			user.setPathOfHead(path + File.separator + filename);
			um.updateUser(user);
			model.addAttribute("user", user);
			System.out.println("上传至路径："+path + File.separator + filename);
			return "ed-person";
		}
		return "ed-index";
	}
	
	@PostMapping("/subBgPic")
	public String subBgPic(@SessionAttribute(value="user") User user,
			HttpServletRequest request,
			@RequestParam("file") MultipartFile file,
			Model model) throws Exception{
		if(!file.isEmpty()){
			String path = request.getServletContext().getRealPath("/headImage");
			String name = file.getOriginalFilename();
			String filename = String.valueOf(user.getID())+"bg."+name.substring(name.length()-3, name.length());
			File filepath = new File(path, filename);
			if(!filepath.getParentFile().exists()){
				filepath.getParentFile().mkdirs();
			}
			file.transferTo(new File(path + File.separator + filename));
			user.setPathOfBg(path + File.separator + filename);
			um.updateUser(user);
			model.addAttribute("user", user);
			System.out.println("上传至路径："+path + File.separator + filename);
			return "ed-person";
		}
		return "ed-index";
	}
	
	@PostMapping("submitDraft")
	public String submitDraft(@RequestParam("pid") int pid,
			@RequestParam("ID") int ID, 
			@RequestParam("theme") String theme,
			@RequestParam("comCon") String comCon,
			@RequestParam("type") String type){
		Draft draft = new Draft(pid, ID, theme, comCon);
		Essay essay = new Essay(draft, type);
		edm.addEssay(essay);
		edm.deleteDraft(pid);
		return "ed-index";
	}
	
	@PostMapping("saveDraft")
	public String saveDraft(@RequestParam("pid") int pid,
			@RequestParam("ID") int ID, 
			@RequestParam("theme") String theme,
			@RequestParam("comCon") String comCon){
		Draft draft = new Draft(pid, ID, theme, comCon);
		edm.updateDraft(draft);
		return "ed-upload";
	}
	
	@RequestMapping("loginout")
	public String loginout(HttpSession session){
		session.invalidate();
		return "redirect:/login";
	}
	
	
}
