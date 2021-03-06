package service;

import java.util.List;

import domain.ProductVO;

public interface ProductService {
	public int register(ProductVO pvo);

	public List<ProductVO> getList();

	public ProductVO getOne(long pno);

	public int modify(ProductVO pvo);

	public int remove(long pno);

	public ProductVO getOneAndUp(Long pno);
}
