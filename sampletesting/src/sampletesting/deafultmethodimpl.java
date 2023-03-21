package sampletesting;

public class deafultmethodimpl implements defaultinterface1, defaultinterface2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		deafultmethodimpl d1 = new deafultmethodimpl();
		d1.show();
		System.out.println(n);

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		defaultinterface2.super.show();
	}

	

}
