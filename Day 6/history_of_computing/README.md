# History of Computing
The history of computing is clean, clear way to look at the history and development of computing since it's inception to the present day, I want it to serve the purpose of educating someone who might just be curious as to how it began but also help someone that wants to look at the history of computing in a more in depth, meaningful way. Whether it be for their own story or even perhaps something that could be referenced in a school envrionment. The people that would to come to this site are people that want to see a minimal webiste that has the information that they are looking for that is easy to read and if they want they will also be able to access more information about a specific person or invention if it is just one particular thing they are looking for. Perhaps this person would be school student looking for info for some school/home work, or even someone that wants to write their own story or website that is looking for a source of information that they can use for their own projects that goes from the 1800's to the present day.

![mockup_gen](https://user-images.githubusercontent.com/83232441/123788870-70ad3d00-d8d4-11eb-905b-4625274eb172.jpg)

### Technology & Features
I'll be using mainly HTML and CSS to create a stylish reponsive webiste that is easy to navigate and easy to intuit at glance once someone has entered the website.
There will be 3 pages to the history of computing. 
1. The main landing (index.html) page where the bulk of the information with links to sources of information that will open on new tabs for those who want as much info as possible
2. A gallery page which will feature a simple collage of the people that the main page are refering too, and if people want to know more about the people rather than their inventions they can just click on the photo and that will open up into a new tab where they can read up on the person.
3. A final sign up page where people can subscribe to a newsletter with the idea behind that of being able to keep people up to date with developments in the computing world (the sign up page will not actually subscribe people to anything how ever in the future that would be something I would like to implement so that would be possibe).
4. I used google fonts to help me decide what font theme I wanted for my website.
5. I used material.io color tool to help choose the color theme for my website.
6. I used fontawesome to get the icons I used for 'i' icons as links for more info on the main page, and also for the social media icons I used for the footer.

### Website Navigation and Footer
A nav bar will be present across all pages that will link the user to the part of the website they wish to see with a main logo that will also serve as a link to take the user back to the main landing page at any time. A gallery link will be present along with a link to take a user to the sign up page as well.

-Desktop nav bar:(Tablet version of nav bar is the same as the desktop just slightly compressed)

![desktop_nav](https://user-images.githubusercontent.com/83232441/123541197-175dd600-d73b-11eb-838d-2c9120b93f07.jpg)

-Mobile nav bar:

![mobile_nav](https://user-images.githubusercontent.com/83232441/123541243-63a91600-d73b-11eb-9f91-892dec5112d2.jpg)

-Footer (Footer style is the same across screen sizes)

![footer](https://user-images.githubusercontent.com/83232441/123796062-9e967f80-d8dc-11eb-8585-d713c57e8190.jpg)


### The landing Page
The main landing page has a minimalistic style that clearly conveys information in easy to read way, with written info onm the left with the title about what the invention is and a photo of the invention to the right with a line down that goes down vertically on the page. Next to the title of the written info there is an 'i' icon. Just before the timeline starts there are a few lins that explain what the what website and explaining what the 'i' icons is for. When in mobile phone screen size the timeline will compress into one column where the title, date, info and photo will all be in one block as illustrated below.

-Mobile screen size timeline:

![timeline_mobile](https://user-images.githubusercontent.com/83232441/123542166-f0ee6980-d73f-11eb-8844-680d80e6b4a8.jpg)

-Desktop & tablet screen size timeline:

![tab_desktop_timeline](https://user-images.githubusercontent.com/83232441/123542207-3874f580-d740-11eb-84fe-0f4c8ddc9118.jpg)


### The Gallery Page
The Gallery page is a simple collection of photos of all the people that arthe creators of the inventions in the main page, if someone wants to learn more about the person and who they are they simlpy need to click on the photo and it will open a new website in a new tab where they can read more about the person rather than the invention it's self. The Gallery page page also adjusts for different screen sizes for desktop and tablet it consits of 5 columns of photos and when on smaller mobile devices it reduces down to 2 columns. Shown below in screen shots

-Gallery desktop and tablet view:

![gallery_desktop_tab](https://user-images.githubusercontent.com/83232441/123542609-7246fb80-d742-11eb-9b14-4fcc0c4a1aab.jpg)

-Gallery mobile view:

![gallery_mobile](https://user-images.githubusercontent.com/83232441/123542757-48da9f80-d743-11eb-9df1-1b53c47f906e.jpg)


### Subscription Page
The subscription page is a simple sign up for a newsletter that asks for someones first name, last name and email address, with a submit buttom that says 'subscribe'. However there is no newsletter to sign up too and the subscribe button doesn't go anywhere. This is one of the things I would like to inpliment in the future and learn how how and where a newsletter for example comes from and how to impliment into a website like mine. As the other pages the subscription box does adjust depending on the screen size, shown below.

-Subscription page desktop and tablet view:

![sub_desktop](https://user-images.githubusercontent.com/83232441/123543269-8c360d80-d745-11eb-82d5-3be725944842.jpg)

-Subscription page mobile view:

![sub_mobile](https://user-images.githubusercontent.com/83232441/123543302-b687cb00-d745-11eb-9366-044c7ced1b4d.jpg)


### External Sources for Code
I had to learn how to create a timeline using CSS and html in my own time in order to create the website that I wanted, I spent time watching some YouTube videos and reading online from various websites that I will link below. However the code I wrote is not simply copied and pasted I used what learnt to inspire my code to be as original as I possibly could with what I had to learn in the time I had to learn it, without it impacting the deadline for this project. The videos and websites I used to teach myself are as follows.
1. https://www.youtube.com/watch?v=zNccqv0g6Q4
2. https://www.youtube.com/watch?v=X6aMWDDJlJg
3. https://www.youtube.com/watch?v=TcYSRI1JFQE
4. https://freefrontend.com/css-timelines/
5. https://www.w3schools.com/howto/howto_css_timeline.asp

### Bugs, Code Validation and testing
1. A bug where the nav bar wasnt presenting correctly in a mobile phone screen size - fixed: Fixed by remaking the original nav bar into a burger button with a small animation.
2. Bug where if the written content box is vertically longer than the picture next to it the next ".left" content box will not sit on the left side of the page - fixes: ensure that the picture being used is of a bigger size and to make sure the written content is not vertically longer the than photo or increase margin bottom size for image div on the right side of the page and decrease margin bottom size for the written content div on the left side of the page. This allows sligtly more space for written conent (if needed) and decreases chance of div being forced to the right of the page.
3. CSS & html code is regularly checked using w3c html markup validation serice and w3c css valdation service websites.
4. Bug/human error with file paths for css and images to be displayed in github pages. the "/" had to be removed from the beginning of all file paths linking to css stylesheet and images in the content of the website in order to be shown on github pages.
5. A bug where the burger nav wasnt working properly on smaller screen sizes - fix: reverted back to just css for screen size adjustments a placed nav links below logo on smaller screens.
6. Cheking 'i' icon links by simply clicking them all on live server browser and making sure they all open to the relevent pages, same goes for checking links on gallery photo links.

###Unfixed bugs
1. No unfixed bugs

###Deployment
Deployed using github pages after commiting and pushing the most up to date code to the github repository, then moving to settings tab, going to pages section, selected master branch as source and saving. Then the link for the website for the github pages link is refreshed and says it's ready to to be published.
- Live link to website: https://olliemoss.github.io/history_of_computing/index.html

###Credits
All the information that is on my website was sourced from external websites that are the linked in the 'i' icons nect to each heading and summarised as best as I could to fit the aesthetic of my page. Also also do not claim any copyright ownership of the photos used on the website and that is stated below each photo. The copyright to the photos used in the gallery page are also not owned by me.
