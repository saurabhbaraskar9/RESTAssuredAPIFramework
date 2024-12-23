package resources;

import java.util.ArrayList;
import java.util.List;

import pojo.AddPlace;
import pojo.Location;
import pojo.UpdatePlace;

public class TestDataBuild {

	AddPlace p =new AddPlace();
	UpdatePlace u = new UpdatePlace();

	public AddPlace addPlacePayLoad(String name, String language, String address)
	{

		p.setAccuracy(50);
		p.setAddress(address);
		p.setLanguage(language);
		p.setPhone_number("(+91) 7757803794");
		p.setWebsite("https://github.com/saurabhbaraskar9");
		p.setName(name);
		List<String> myList =new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");

		p.setTypes(myList);
		Location l =new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		return p;
	}
	
	public String deletePlacePayload(String placeId)
	{
		return "{\r\n    \"place_id\":\""+placeId+"\"\r\n}";
	}

	public UpdatePlace updatePlacePayload(String placeId, String address, String key)
	{
		u.setPlace_id(placeId);
		u.setAddress(address);
		u.setKey(key);
		return u;
    }
}
