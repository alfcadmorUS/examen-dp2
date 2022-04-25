package acme.features.authenticated.announcements;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.announcement.Announcement;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class authenticatedAnnouncementsListService implements AbstractListService<Authenticated, Announcement> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected authenticatedAnnouncementsRepository repository;

	// AbstractListService<Anonymous, Announcement>  interface -------------------------


	@Override
	public boolean authorise(final Request<Announcement> request) {
		assert request != null;

		return true;
	}
	
	@Override
	public Collection<Announcement> findMany(final Request<Announcement> request) {
		assert request != null;

		Collection<Announcement> result;

		result = this.repository.findManyAnnouncement();

		return result;
	}
	
	@Override
	public void unbind(final Request<Announcement> request, final Announcement entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "body", "title");
	}

}
