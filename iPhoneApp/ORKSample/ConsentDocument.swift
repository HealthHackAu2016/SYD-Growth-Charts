/*
Copyright (c) 2015, Apple Inc. All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

1.  Redistributions of source code must retain the above copyright notice, this
list of conditions and the following disclaimer.

2.  Redistributions in binary form must reproduce the above copyright notice,
this list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

3.  Neither the name of the copyright holder(s) nor the names of any contributors
may be used to endorse or promote products derived from this software without
specific prior written permission. No license is granted to the trademarks of
the copyright holders even if such marks are included in this software.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

import ResearchKit

class ConsentDocument: ORKConsentDocument {
    // MARK: Properties
    
    let ipsum = [
        "Our study looks at rare bone diseases. We hope to gather the biggest rare bone disorder growth dataset in the world to build useful growth charts for those with rare bone disorders.",
        "Record your growth. We ask for very basic data points like age, height, weight, and head circumference to track an individual's growth.",
        "Keep your data secure. We do not store any personally identifiable information. All data set to us will be with your consent and will only contain basic metrics such as age, height, width, and head circumference.",
        "Add your data to the herd. Your data is important to gather information on these rare diseases and we hope to be abe to build useful growth curves for clinicians with your data.",
        "Takes 5 minutes. Send data when you have time. Only send data when you are available and wish to share.",
        "Answer 5 questions.",
        "Enter your date of birth, height, weight, and head circumference.`",
        "Withdraw at any time. Revoke your consent to use your data at any time and we will remove it from our data set. There is no obligation to continue to use your data after you refuse to share your data."
    ]
    
    // MARK: Initialization
    
    override init() {
        super.init()
        
        title = NSLocalizedString("Research Health Study Consent Form", comment: "")
        
        let sectionTypes: [ORKConsentSectionType] = [
            .overview,
            .dataGathering,
            .privacy,
            .dataUse,
            .timeCommitment,
            .studySurvey,
            .studyTasks,
            .withdrawing
        ]
        
        sections = zip(sectionTypes, ipsum).map { sectionType, ipsum in
            let section = ORKConsentSection(type: sectionType)
            
            let localizedIpsum = NSLocalizedString(ipsum, comment: "")
            let localizedSummary = localizedIpsum.components(separatedBy: ".")[0] + "."
            
            section.summary = localizedSummary
            section.content = localizedIpsum
            
            return section
        }

        let signature = ORKConsentSignature(forPersonWithTitle: nil, dateFormatString: nil, identifier: "ConsentDocumentParticipantSignature")
        addSignature(signature)
    }

    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
}

extension ORKConsentSectionType: CustomStringConvertible {

    public var description: String {
        switch self {
            case .overview:
                return "Overview"
                
            case .dataGathering:
                return "DataGathering"
                
            case .privacy:
                return "Privacy"
                
            case .dataUse:
                return "DataUse"
                
            case .timeCommitment:
                return "TimeCommitment"
                
            case .studySurvey:
                return "StudySurvey"
                
            case .studyTasks:
                return "StudyTasks"
                
            case .withdrawing:
                return "Withdrawing"
                
            case .custom:
                return "Custom"
                
            case .onlyInDocument:
                return "OnlyInDocument"
        }
    }
}
