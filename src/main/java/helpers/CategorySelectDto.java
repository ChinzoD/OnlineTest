package helpers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.pm.onlinetest.domain.Category;
import com.pm.onlinetest.domain.Subcategory;

@Component
public class CategorySelectDto {
	
	List<Integer> selectedSubCategories = new ArrayList<>();	
	List<Category> categories = new ArrayList<>();
	List<Subcategory> subCategories = new ArrayList<>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Integer> getSelectedSubCategories() {
		return selectedSubCategories;
	}

	public void setSelectedSubCategories(List<Integer> selectedSubCategories) {
		this.selectedSubCategories = selectedSubCategories;
	}

	@Override
	public String toString() {
		return "CategorySelectDto selectedSubCategories=" + selectedSubCategories + "";
	}

	public List<Subcategory> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Subcategory> subCategories) {
		this.subCategories = subCategories;
	}
	
	

}
