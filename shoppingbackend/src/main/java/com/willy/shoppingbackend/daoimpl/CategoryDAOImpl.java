package com.willy.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import com.willy.shoppingbackend.dao.CategoryDAO;
import com.willy.shoppingbackend.dto.Category;



@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
      
		category.setId(1);
		category.setName("Television");
		category.setDescription("est la description de television");
		category.
		setImageURL("CAT_1.png");
		
		categories.add(category);
	
		
		
		category = new Category();
	      
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("est la description de mobile");
		category.
		setImageURL("CAT_2.png");
		
		categories.add(category);
		
		
		category = new Category();
	      
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("est la description de Laptop");
		category.
		setImageURL("CAT_3.png");
		
		categories.add(category);
	
	
	}
	
	
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	public Category get(int id) {

		for(Category category : categories) {
			if(category.getId() == id)
				return category;
		}
		
		return null;
	}


	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);;
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

}
