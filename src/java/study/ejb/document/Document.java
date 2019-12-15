/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package study.ejb.document;

import java.util.List;
import javax.ejb.Stateless;
import study.ejb.document.helpers.Reader;

/**
 *
 * @author dzmitry
 */
@Stateless
public class Document implements DocumentRemote {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
        
    public static Reader reader;
    
    public Document() {        
        this.reader = new Reader(
                            "study/web/document/resources/documents.xml", 
                            "study/web/document/resources/documents.xsd"
                        );
        
        this.reader.read();
    }
    
    @Override
    public List<study.ejb.document.entity.Document> getList() {
        return this.reader.getList();
    }

    @Override
    public study.ejb.document.entity.Document search(String id) {
        return this.reader.search(id);
    }

    @Override
    public boolean add(int id, String title, String content) {
        return this.reader.add(id, title, content);
    }

    @Override
    public boolean delete(String id) {
        return this.reader.delete(id);
    }

    @Override
    public void save() {
        this.reader.save();
    }
    
    
    
}
