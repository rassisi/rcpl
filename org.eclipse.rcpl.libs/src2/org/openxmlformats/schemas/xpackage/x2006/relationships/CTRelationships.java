/*
 * XML Type:  CT_Relationships
 * Namespace: http://schemas.openxmlformats.org/package/2006/relationships
 * Java type: org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships
 *
 * Automatically generated - do not modify.
 */
package org.openxmlformats.schemas.xpackage.x2006.relationships;


/**
 * An XML CT_Relationships(@http://schemas.openxmlformats.org/package/2006/relationships).
 *
 * This is a complex type.
 */
public interface CTRelationships extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(CTRelationships.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s0B482D0B338CC9641C1543C3510577FE").resolveHandle("ctrelationshipse33ftype");
    
    /**
     * Gets a List of "Relationship" elements
     */
    java.util.List<org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship> getRelationshipList();
    
    /**
     * Gets array of all "Relationship" elements
     * @deprecated
     */
    org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship[] getRelationshipArray();
    
    /**
     * Gets ith "Relationship" element
     */
    org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship getRelationshipArray(int i);
    
    /**
     * Returns number of "Relationship" element
     */
    int sizeOfRelationshipArray();
    
    /**
     * Sets array of all "Relationship" element
     */
    void setRelationshipArray(org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship[] relationshipArray);
    
    /**
     * Sets ith "Relationship" element
     */
    void setRelationshipArray(int i, org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship relationship);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "Relationship" element
     */
    org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship insertNewRelationship(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "Relationship" element
     */
    org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationship addNewRelationship();
    
    /**
     * Removes the ith "Relationship" element
     */
    void removeRelationship(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships newInstance() {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (org.openxmlformats.schemas.xpackage.x2006.relationships.CTRelationships) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
