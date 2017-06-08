package org.unidal.lookup.container.model.entity;

import java.util.ArrayList;
import java.util.List;

import org.unidal.lookup.container.model.BaseEntity;
import org.unidal.lookup.container.model.IVisitor;

public class ComponentModel extends BaseEntity<ComponentModel> {
   private String m_role;

   private String m_roleHint = "default";

   private String m_implementation;

   private String m_instantiationStrategy = "singleton";

   private ConfigurationModel m_configuration;

   private List<RequirementModel> m_requirements = new ArrayList<RequirementModel>();

   public ComponentModel() {
   }

   @Override
   public void accept(IVisitor visitor) {
      visitor.visitComponent(this);
   }

   public ComponentModel addRequirement(RequirementModel requirement) {
      m_requirements.add(requirement);
      return this;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof ComponentModel) {
         ComponentModel _o = (ComponentModel) obj;

         if (!equals(m_role, _o.getRole())) {
            return false;
         }

         if (!equals(m_roleHint, _o.getRoleHint())) {
            return false;
         }

         if (!equals(m_implementation, _o.getImplementation())) {
            return false;
         }

         if (!equals(m_instantiationStrategy, _o.getInstantiationStrategy())) {
            return false;
         }

         if (!equals(m_configuration, _o.getConfiguration())) {
            return false;
         }

         if (!equals(m_requirements, _o.getRequirements())) {
            return false;
         }


         return true;
      }

      return false;
   }

   public ConfigurationModel getConfiguration() {
      return m_configuration;
   }

   public String getImplementation() {
      return m_implementation;
   }

   public String getInstantiationStrategy() {
      return m_instantiationStrategy;
   }

   public List<RequirementModel> getRequirements() {
      return m_requirements;
   }

   public String getRole() {
      return m_role;
   }

   public String getRoleHint() {
      return m_roleHint;
   }

   @Override
   public int hashCode() {
      int hash = 0;

      hash = hash * 31 + (m_role == null ? 0 : m_role.hashCode());
      hash = hash * 31 + (m_roleHint == null ? 0 : m_roleHint.hashCode());
      hash = hash * 31 + (m_implementation == null ? 0 : m_implementation.hashCode());
      hash = hash * 31 + (m_instantiationStrategy == null ? 0 : m_instantiationStrategy.hashCode());
      hash = hash * 31 + (m_configuration == null ? 0 : m_configuration.hashCode());
      for (RequirementModel e : m_requirements) {
         hash = hash * 31 + (e == null ? 0 :e.hashCode());
      }


      return hash;
   }

   @Override
   public void mergeAttributes(ComponentModel other) {
   }

   public ComponentModel setConfiguration(ConfigurationModel configuration) {
      m_configuration = configuration;
      return this;
   }

   public ComponentModel setImplementation(String implementation) {
      m_implementation = implementation;
      return this;
   }

   public ComponentModel setInstantiationStrategy(String instantiationStrategy) {
      m_instantiationStrategy = instantiationStrategy;
      return this;
   }

   public ComponentModel setRole(String role) {
      m_role = role;
      return this;
   }

   public ComponentModel setRoleHint(String roleHint) {
      m_roleHint = roleHint;
      return this;
   }

   /********* Code Snippet Start *********/
   public boolean isEnum() {
      return "enum".equals(m_instantiationStrategy);
   }

   public boolean isPerLookup() {
      return "per-lookup".equals(m_instantiationStrategy);
   }

   public boolean isSingleton() {
      return "singleton".equals(m_instantiationStrategy);
   }

   /********* Code Snippet End *********/
}
