package fr.ichida.example.service;

import fr.ichida.example.entity.Conference;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit tests for {@link ConferenceService}.
 *
 * @author shoun
 * @since 12/01/2016
 */
public class ConferenceServiceTest {

    @Test
    public void testRegister() throws Exception {
        ConferenceService conferenceService = new ConferenceService();

        Conference c1 = new Conference();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        conferenceService.register(c1);
        assertThat(conferenceService.getConferences()).containsValues(c1);

        Conference c2 = new Conference();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c2);
        assertThat(conferenceService.getConferences()).containsValues(c1, c2);
    }

    @Test
    public void testFindAll() throws Exception {
        ConferenceService conferenceService = new ConferenceService();

        Conference c1 = new Conference();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Conference c2 = new Conference();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);
        assertThat(conferenceService.findAll()).containsOnly(c1, c2);
    }

    @Test
    public void testFindBySpeaker() throws Exception {
        ConferenceService conferenceService = new ConferenceService();

        Conference c1 = new Conference();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Conference c2 = new Conference();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);
        assertThat(conferenceService.findBySpeaker("Speaker 1")).isEqualTo(c1);
        assertThat(conferenceService.findBySpeaker("Speaker 2")).isEqualTo(c2);
        assertThat(conferenceService.findBySpeaker("Do not exist")).isNull();
    }

    @Test
    public void testAddMark() throws Exception {
        ConferenceService conferenceService = new ConferenceService();

        Conference c1 = new Conference();
        c1.setId(1);
        c1.setSpeaker("Speaker 1");
        c1.setSubject("Subject 1");
        c1.setMark(0.0);

        Conference c2 = new Conference();
        c2.setId(2);
        c2.setSpeaker("Speaker 2");
        c2.setSubject("Subject 2");
        c2.setMark(0.0);

        conferenceService.register(c1);
        conferenceService.register(c2);

        assertThat(conferenceService.addMark("Speaker 1", 5.0).getMark()).isEqualTo(5.0);
        assertThat(conferenceService.addMark("Speaker 1", 6.0).getMark()).isEqualTo(5.5);
        assertThat(conferenceService.addMark("Speaker 1", 7.0).getMark()).isEqualTo(6.0);
    }
}