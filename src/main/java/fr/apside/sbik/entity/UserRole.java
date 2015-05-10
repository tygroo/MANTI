package fr.apside.sbik.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import fr.apside.sbik.util.Role;

@Entity
@Table(name = "user_roles", uniqueConstraints = { @UniqueConstraint(columnNames = "user_role_id"), @UniqueConstraint(columnNames = "ROLE")})
public class UserRole implements IEntity<Integer> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_role_id", unique = true, nullable = false)
  private Integer id;

  @Enumerated(EnumType.STRING)
  @Column(name = "ROLE", unique = true, nullable = false)
  private Role role;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role rOLE) {
    role = rOLE;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserRole other = (UserRole) obj;
    if (role != other.role)
      return false;
    if (id != other.id)
      return false;
    return true;
  }

}
