package hfoster.android.inthenear;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

@SuppressWarnings("rawtypes")
public class ITNItemizedOverlay extends ItemizedOverlay {
	
	private ArrayList<OverlayItem> overlays = new ArrayList<OverlayItem>();
	private Context context;

	public ITNItemizedOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}
	
	public ITNItemizedOverlay(Drawable defaultMarker, Context newContext) {
		super(defaultMarker);
		this.context = newContext;
	}
	
	public void addOverlay(OverlayItem overlay) {
		overlays.add(overlay);
		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return overlays.get(i);
	}

	@Override
	public int size() {
		return overlays.size();
	}
	
	@Override
	protected boolean onTap(int index) {
		OverlayItem item = overlays.get(index);
		return true;
	}

}
