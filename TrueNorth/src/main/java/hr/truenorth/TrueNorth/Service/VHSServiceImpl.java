package hr.truenorth.TrueNorth.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import hr.truenorth.TrueNorth.Model.VHS;
import hr.truenorth.TrueNorth.Repository.VHSRepository;

@Service
public class VHSServiceImpl implements VHSService {

	private final VHSRepository iVHSRepository;
	
	public VHSServiceImpl(VHSRepository VHSRepository) {
		this.iVHSRepository = VHSRepository;
	}
	
	@Override
	public List<VHS> getAllVHS() {
		return iVHSRepository.getAllVHS();
	}

	@Override
	public long getNoOfVHS() {
		return iVHSRepository.count();
	}

	@Override
	public void addVHS(VHS vhs) {
		iVHSRepository.save(vhs);
	}

	@Override
	public VHS getVHSById(int id) {
		return iVHSRepository.getVHSById(id);
	}

}
