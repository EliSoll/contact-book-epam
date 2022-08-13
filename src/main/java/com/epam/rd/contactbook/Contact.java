package com.epam.rd.contactbook;

public class Contact {

    private  String nameContactInfoName;
    private ContactInfo[] finalContactInfoEntries;


    private int counterSocial, emailCounter, counterPhone, indexOfEmail = 2, indexOfSocial = 5;
    private ContactInfo[] contactInfoEntries = new ContactInfo[10];

    private String nameContact;






    public Contact(String name) {
        if (name != null) {


            this.nameContact = name;
            this.nameContactInfoName = name;
            contactInfoEntries[0] = new NameContactInfo();

        }
    }



     private  class NameContactInfo implements ContactInfo {




         @Override
        public String getTitle() {
            return "Name";
        }

        @Override
        public String getValue() {
            return nameContact;
        }



    }

    public static class Email implements ContactInfo {

        private String title, value;

        public Email(String title, String value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public static class Social implements ContactInfo {

        private String title, value;


        public Social(String title, String linkId) {
            this.title = title;
            this.value = linkId;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return value;
        }
    }

    public void rename(String newName) {

        if (newName != null && !newName.equals(" ")) {
            this.nameContact = newName;
            this.nameContactInfoName = newName;

            finalContactInfoEntries[0] = new NameContactInfo();

            }
        }



    public Email addEmail(String localPart, String domain) {
       if(localPart != null && domain != null) {
           String title = "Email";
           String value = localPart + "@" + domain;
           Contact.Email email = new Contact.Email(title, value);
           if (emailCounter < 3 && indexOfEmail <= 4) {
               contactInfoEntries[indexOfEmail++] = email;
               emailCounter++;
               return email;
           }
       }
return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        if(firstname != null && lastname != null) {
            String title = "Epam Email";
            String value = firstname + "_" + lastname + "@epam.com";
            Contact.Email epamEmail = new Contact.Email(title, value) {
                @Override
                public String getTitle() {
                    return title;
                }

                @Override
                public String getValue() {
                    return value;
                }
            };
            if (emailCounter < 3 && indexOfEmail <= 4) {
                contactInfoEntries[indexOfEmail++] = epamEmail;
                emailCounter++;
                return epamEmail;
            }
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {

        ContactInfo phoneNumber = new ContactInfo() {

            @Override
            public String getTitle() {
                return "Tel";
            }

            @Override
            public String getValue() {
                return "+" + code + " " + number;
            }
        };
        if (counterPhone < 1) {
        counterPhone++;
                return contactInfoEntries[1] = phoneNumber; }
        return null;
    }


    public Social addTwitter(String twitterId) {
        if (twitterId != null) {
            String title = "Twitter";
            Contact.Social twitter = new Contact.Social(title, twitterId);
            if(counterSocial < 5 && indexOfSocial <= 9) {
                contactInfoEntries[indexOfSocial++] = twitter;
                counterSocial++;
                return twitter;
            }
        }
        return null;
    }


    public Social addInstagram(String instagramId) {
        if (instagramId != null) {
            String title = "Instagram";
            Contact.Social instagram = new Contact.Social(title, instagramId);
            if(counterSocial < 5 && indexOfSocial <= 9) {
                contactInfoEntries[indexOfSocial++] = instagram;
                counterSocial++;
                return instagram;
            }
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        if (title != null && id != null) {
            Social socialMedia = new Social(title, id);
            if (counterSocial < 5 && indexOfSocial <= 9) {
                contactInfoEntries[indexOfSocial++] = socialMedia;
                counterSocial++;
                return socialMedia;
            }
        }
        return null;
    }

    public ContactInfo[] getInfo() {
       int counterTotal = counterPhone + emailCounter + counterSocial + 1;
      finalContactInfoEntries = new ContactInfo[counterTotal];
       int i = 0;
       for (ContactInfo value : contactInfoEntries) {
           if(value != null) {
               finalContactInfoEntries[i++] = value;
           }
       }
       return finalContactInfoEntries;
    }
}
