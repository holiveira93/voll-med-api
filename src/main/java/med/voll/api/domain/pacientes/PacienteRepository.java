package med.voll.api.domain.pacientes;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository <PacienteEntity, Long> {

    Page<PacienteEntity> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo from PacienteEntity p
            where p.id = :id
            """)
    boolean findAtivoById(Long id);
}
