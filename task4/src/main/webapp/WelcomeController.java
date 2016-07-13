
@Controller
public class WelcomeController{
    private int visitorCount = 0;

    @RequestMapping("/index.html");
    public String index(Model model){
            model.addAttribute("visitorCount", visitorCount++);
            return "WEB-INF/jsp/index.jsp";
    }

}