package com.techouts.bookStoreDao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.techouts.bookStore.Model.ActionAndAdventures;
import com.techouts.bookStore.Model.BookStoreCart;
import com.techouts.bookStore.Model.GenralStudies;
import com.techouts.bookStore.Model.HistoricalFiction;
import com.techouts.bookStore.Model.Horror;
import com.techouts.bookStore.Model.RomCom;
import com.techouts.bookStore.Model.ScienceFiction;
import com.techouts.bookStore.Model.Thriller;
import com.techouts.bookStore.Model.UserInfo;

public class Operations {
	// Session session;
	//static Transaction transaction;

	/*
	 * public void run(Registration registration) { session.save(registration);
	 */

	Session session;

	public Operations() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
		SessionFactory factory = metadata.getSessionFactoryBuilder().build();
		session = factory.openSession();
		
	}

	public void registerUser(String fname, String lname, int phone, String mail, String gender, String loc, String pass,
			String repass) {
		Transaction transaction = session.beginTransaction();
		UserInfo registration = new UserInfo();
		registration.setFirstName(fname);
		registration.setLastName(lname);
		registration.setPhoneNumber(phone);
		registration.setEmailId(mail);
		registration.setGender(gender);
		registration.setLocation(loc);
		registration.setPassword(pass);
		registration.setRepassword(repass);
		session.save(registration);
		System.out.println("registered successfully");
		transaction.commit();
		//session.close();

	}

	public boolean getUser(int phone, String password) {

		UserInfo registration = session.get(UserInfo.class, phone);
		// System.out.println(registration);
		System.out.println(registration.getEmailId());
		String pass = registration.getPassword();
		System.out.println(registration.getPassword());

		if (!password.equals(pass)) {
			// System.out.println("heeeeee");
			return false;
		} else {

			return true;
		}

		// return registration;

	}

	@SuppressWarnings("unchecked")
	 public List<ActionAndAdventures> action() throws IOException, SerialException, SQLException {

		// Criteria criteria = session.createCriteria(ActionAndAdventure.class);

		// List<ActionAndAdventure> li = criteria.list();
		Query<ActionAndAdventures> q = session.createQuery("from ActionAndAdventures");
		List<ActionAndAdventures> l = q.list();
		for (ActionAndAdventures ad : l) {
			// System.out.println(ad);
        
			 
			while(ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();
				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		//session.close();
		return l;

	}

	@SuppressWarnings("unchecked")
	public List<ScienceFiction> getSfiction() throws SerialException, SQLException, IOException {

		Query<ScienceFiction> q = session.createQuery("from ScienceFiction");
		List<ScienceFiction> l = q.getResultList();
		for (ScienceFiction ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;

	}

	@SuppressWarnings("unchecked")
	public List<Thriller> getThriller() throws SerialException, SQLException, IOException {

		Query<Thriller> q = session.createQuery("from Thriller");
		List<Thriller> l = q.getResultList();
		for (Thriller ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;

	}

	@SuppressWarnings("unchecked")
	public List<Horror> getHorror() throws SerialException, SQLException, IOException {
		Query<Horror> q = session.createQuery("from Horror");
		List<Horror> l = q.getResultList();
		for (Horror ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;

	}

	@SuppressWarnings("unchecked")
	public List<HistoricalFiction> getHistoricalFiction() throws SerialException, SQLException, IOException {
		Query<HistoricalFiction> q = session.createQuery("from HistoricalFiction");
		List<HistoricalFiction> l = q.getResultList();
		for (HistoricalFiction ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;
	}

	@SuppressWarnings("unchecked")
	public List<RomCom> getRomCom() throws SerialException, SQLException, IOException {
		Query<RomCom> q = session.createQuery("from RomCom");
		List<RomCom> l = q.getResultList();
		for (RomCom ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;

	}

	@SuppressWarnings("unchecked")
	public List<GenralStudies> getGeneralStudies() throws SerialException, SQLException, IOException {
		Query<GenralStudies> q = session.createQuery("from GenralStudies");
		List<GenralStudies> l = q.getResultList();
		for (GenralStudies ad : l) {
			// System.out.println(ad);

			while (ad.getBase64Image() == null) {
				byte[] image = ad.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				ad.setBase64Image(base64Image);
				System.out.println("query executed2");
			}
		}
		return l;

	}

	@SuppressWarnings("unchecked")
	public int deleteBook(int id) {

		// transaction.begin();
		/*
		 * // ActionAndAdventure actionAndAdventure=new ActionAndAdventure(); //
		 * actionAndAdventure.getBookId(); //
		 * session.delete(actionAndAdventure.getBookId()); //
		 */
		Query<ActionAndAdventures> q = session.createQuery("delete from ActionAndAdventure where bookId=" + id + "");
		int i = q.executeUpdate();
		// transaction.commit();
		// session.close();

		return i;

	}

	@SuppressWarnings("unchecked")
	public List<ActionAndAdventures> addCart(int id) {

		Query<ActionAndAdventures> a = session.createQuery(" from ActionAndAdventures  where bookId=" + id + "");
		List<ActionAndAdventures> s = a.list();
		//System.out.println(s);

		// List<ActionAndAdventure> lit=a.list();
		// for(ActionAndAdventure l:lit){
		// ActionAndAdventure actionAndAdventure =
		// (ActionAndAdventure)session.get(ActionAndAdventure.class, id);
		// System.err.println(l.getBookName());
		// transaction.begin();
		// BookStoreCart bookStoreCart = new BookStoreCart();
		// bookStoreCart.setBookId(actionAndAdventure.getBookId());
		// bookStoreCart.setBookName(actionAndAdventure.getBookName());
		// bookStoreCart.setBookAuthor(actionAndAdventure.getBookAuthor());
		// bookStoreCart.setBookPrice(actionAndAdventure.getBookPrice());
		// bookStoreCart.setBase64Image(actionAndAdventure.getBase64Image());
		// session.save(bookStoreCart);
		// System.out.println("thank you");
		// }

		// session.close();
		return s;

	}

	@SuppressWarnings("unchecked")
	public List<ActionAndAdventures> pdpAct(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<ActionAndAdventures> q = session.createQuery("from ActionAndAdventures where bookId= " + id + "");
		
		List<ActionAndAdventures> li = q.list();
		/*			 System.out.println(li.size());
					// System.out.println(li.get(0).toString());
		   for(ActionAndAdventures i:li){

			while (i.getBase64Image() == null) {
				byte[] image = i.getImage();
				Blob blob = new SerialBlob(image);

				InputStream inputStream = blob.getBinaryStream();
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				byte[] imageBytes = outputStream.toByteArray();
				String base64Image = Base64.getEncoder().encodeToString(imageBytes);

				inputStream.close();
				outputStream.close();

				System.out.println("query executed1");
				i.setBase64Image(base64Image);
				System.out.println("query executed2");
			}*/
		
		//session.close();
		   //}
		return li;

	}
	@SuppressWarnings("unchecked")
	public List<HistoricalFiction> pdpHistoricalFiction(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<HistoricalFiction> q = session.createQuery("from HistoricalFiction where bookId= " + id + "");
		
		List<HistoricalFiction> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<ScienceFiction> pdpScienceFiction(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<ScienceFiction> q = session.createQuery("from ScienceFiction where bookId= " + id + "");
		
		List<ScienceFiction> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<Horror> pdpHorrror(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<Horror> q = session.createQuery("from Horror where bookId= " + id + "");
		
		List<Horror> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<Thriller> pdpThriller(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<Thriller> q = session.createQuery("from Thriller where bookId= " + id + "");
		
		List<Thriller> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<RomCom> pdpActRomCom(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<RomCom> q = session.createQuery("from RomCom where bookId= " + id + "");
		
		List<RomCom> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<GenralStudies> pdpGeneral(int id) throws SerialException, SQLException, IOException {

		System.out.println("pdp act method integer "+id);
		Query<GenralStudies> q = session.createQuery("from GeneralStudies where bookId= " + id + "");
		
		List<GenralStudies> li = q.list();
		return li;
	}
	@SuppressWarnings("unchecked")
	public List<HistoricalFiction> historyCart(int id) {

		Query<HistoricalFiction> a = session.createQuery(" from HistoricalFiction  where bookId=" + id + "");
		List<HistoricalFiction> s = a.list();
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<Horror> horrorCart(int id) {

		Query<Horror> a = session.createQuery(" from Horror  where bookId=" + id + "");
		List<Horror> s = a.list();
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<Thriller> thrillerCart(int id) {

		Query<Thriller> a = session.createQuery(" from Thriller  where bookId=" + id + "");
		List<Thriller> s = a.list();
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<RomCom> romcomCart(int id) {

		Query<RomCom> a = session.createQuery(" from RomCom  where bookId=" + id + "");
		List<RomCom> s = a.list();
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<GenralStudies> generalCart(int id) {

		Query<GenralStudies> a = session.createQuery(" from GenralStudies  where bookId=" + id + "");
		List<GenralStudies> s = a.list();
		return s;
	}
	@SuppressWarnings("unchecked")
	public List<ScienceFiction> scienceFictionCart(int id) {

		Query<ScienceFiction> a = session.createQuery(" from ScienceFiction  where bookId=" + id + "");
		List<ScienceFiction> s = a.list();
		return s;
	}



}
