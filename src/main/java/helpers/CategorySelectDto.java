package helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pm.onlinetest.domain.Category;

@Component
public class CategorySelectDto {
	
	List<String> selectedSubCategories = new ArrayList<>();
	
	List<Category> categories = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<String> getSelectedSubCategories() {
		return selectedSubCategories;
	}

	public void setSelectedSubCategories(List<String> selectedSubCategories) {
		this.selectedSubCategories = selectedSubCategories;
	}
	
	

}
