package esig.atividades;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import esig.atividades.model.Atividade;
import esig.atividades.repository.AtividadeRepository;

@Controller
public class IndexController {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@RequestMapping("/")
	public ModelAndView inicio() {
		ModelAndView andView = new ModelAndView("index");
		andView.addObject("atividadeobj", new Atividade());
		
		return andView;
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "**/salvaratividade")
	public ModelAndView salvar(Atividade atividade) {		
		atividadeRepository.save(atividade);
		
		ModelAndView andView = new ModelAndView("index");
		Iterable<Atividade> atividadesIt = atividadeRepository.findAll();
		andView.addObject("atividades", atividadesIt);
		andView.addObject("atividadeobj", new Atividade());
		
		
		return andView;
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaratividades")
	public ModelAndView atividades() {
		ModelAndView andView = new ModelAndView("index");
		Iterable<Atividade> atividadesIt = atividadeRepository.findAll();
		andView.addObject("atividades", atividadesIt);
		andView.addObject("atividadeobj", new Atividade());
		
		
		return andView;
		
	}
	
	@GetMapping("/mudastatus/{idatividade}")
	public ModelAndView mudastatus(@PathVariable("idatividade") Long idatividade) {
		
		Optional<Atividade> atividade = atividadeRepository.findById(idatividade);
		
		ModelAndView andView = new ModelAndView("index");		
		andView.addObject("atividadeobj", atividade.get());
		//andView.addObject("atividadeobj", new Atividade());
		return andView;
		
	}
	
	@GetMapping("/excluiratividade/{idatividade}")
	public ModelAndView excluir(@PathVariable("idatividade") Long idatividade) {
		
		atividadeRepository.deleteById(idatividade);
		
		ModelAndView andView = new ModelAndView("index");		
		andView.addObject("atividades", atividadeRepository.findAll());
		andView.addObject("atividadeobj", new Atividade());
		return andView;
		
	}
	
	@GetMapping("**/pesquisastatusativo")
	public ModelAndView pesquisar() {
		ModelAndView andView =  new ModelAndView("index");
		andView.addObject("atividades", atividadeRepository.findByStatus(null));
		andView.addObject("atividadeobj", new Atividade());
		
		return andView;
		
	} 
	
	@GetMapping("**/pesquisastatusinativo")
	public ModelAndView pesquisaremaberto() {
		ModelAndView andView =  new ModelAndView("index");
		andView.addObject("atividades", atividadeRepository.findByStatusinativo(null));
		andView.addObject("atividadeobj", new Atividade());
		
		return andView;
		
	} 

}
