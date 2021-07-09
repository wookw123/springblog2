package Blog2.springBlog2.controller;

import Blog2.springBlog2.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping({"","/"})
    public String main(Model model , @PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC)Pageable pageable){

        model.addAttribute("postlist" , postService.Postlist(pageable)); //글 목록
        return "index";
    }



    @GetMapping("/post/{id}")
    public String postdetail(@PathVariable int id, Model model){
        model.addAttribute("post" , postService.postDetail(id));
        return "post/postDetail"; //post폴더의 postDetail.html로 가렴
    }


}
