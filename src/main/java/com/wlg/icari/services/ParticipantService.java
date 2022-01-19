package com.wlg.icari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wlg.icari.dao.ParticipantRepository;
import com.wlg.icari.entities.Participant;

@Service
public class ParticipantService 
{
	@Autowired
	private ParticipantRepository participantRepository;
	
	public Participant addParticipant(Participant participant)
	{
		return this.participantRepository.save(participant);
	}
}
