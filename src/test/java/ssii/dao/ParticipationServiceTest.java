package ssii.dao;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ssii.dao.ParticipationRepository;
import ssii.dao.PersonneRepository;
import ssii.dao.ProjetRepository;
import ssii.entity.Participation;
import ssii.entity.Personne;
import ssii.entity.Projet;
import ssii.service.ParticipationService;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ParticipationServiceTest {

    @Test
    void testAjouterParticipation() {
        // Mocks
        Personne personne = new Personne("Dupont", "Jean", "Développeur");
        personne.setMatricule(1);

        Projet projet = new Projet("Projet X", LocalDate.now());
        projet.setCode(1);

        ParticipationRepository participationRepository = mock(ParticipationRepository.class);
        PersonneRepository personneRepository = mock(PersonneRepository.class);
        ProjetRepository projetRepository = mock(ProjetRepository.class);

        when(personneRepository.findById(1)).thenReturn(Optional.of(personne));
        when(projetRepository.findById(1)).thenReturn(Optional.of(projet));
        when(participationRepository.existsByContributeurAndProjet(any(), any())).thenReturn(false);
        when(participationRepository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        ParticipationService service = new ParticipationService(participationRepository, personneRepository, projetRepository);

        Participation participation = service.ajouterParticipation(1, 1, "Manager", 50f);
        assertNotNull(participation);
        assertEquals("Manager", participation.getRole());
        assertEquals(50f, participation.getPourcentage());
        assertEquals(personne, participation.getContributeur());
        assertEquals(projet, participation.getProjet());

        verify(participationRepository, times(1)).save(any(Participation.class));
    }
}
