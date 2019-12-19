package com.zdl.test.dao;



import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zdl.dao.ProductInfoRepository;
import com.zdl.entity.ProductInfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

	@Autowired
	private ProductInfoRepository repository;

	@Test
	public void saveTest() {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId("123457");
		productInfo.setProductName("皮蛋粥");
		productInfo.setProductPrice(new BigDecimal(3.2));
		productInfo.setProductStock(100);
		productInfo.setProductDescription("很好喝的粥");
		productInfo.setProductIcon("http://xxxxx.jpg");
		productInfo.setProductStatus(0);
		productInfo.setCategoryType(2);
		
		ProductInfo result = repository.save(productInfo);
		Assert.assertNotNull(result);
	}

	@Test
	public void testFindByProductStatus() {
		List<ProductInfo> findByProductStatus = repository.findByProductStatus(0);
		Assert.assertNotEquals(0, findByProductStatus.size());
	}
	@Test
	public void testFindOne() {
		System.out.println(repository.findOne("123456").toString());
		
	}

}
