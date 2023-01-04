/* -----------------------------------------
 * Projet Neptune
 *
 * Ecole Centrale Nantes
 * Jean-Yves MARTIN
 * ----------------------------------------- */
package fr.centrale.nantes.neptune.controllers.tools;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author kwyhr
 */
public class FileModel {
   private MultipartFile file;

   public MultipartFile getFile() {
      return file;
   }

   public void setFile(MultipartFile file) {
      this.file = file;
   }
}
