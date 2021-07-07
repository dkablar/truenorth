package hr.truenorth.TrueNorth.Service;

import java.util.List;

import hr.truenorth.TrueNorth.Model.VHS;

public interface VHSService {

	public List<VHS> getAllVHS();
	
	public long getNoOfVHS();
	
	public void addVHS(VHS vhs);
	
	public VHS getVHSById(int id);
}
