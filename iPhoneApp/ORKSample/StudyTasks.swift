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

struct StudyTasks {
    
    static let microphoneTask: ORKOrderedTask = {
        let intendedUseDescription = "Everyone's voice has unique characteristics."
        let speechInstruction = "After the countdown, say Aaaaaaaaaaah for as long as you can. You'll have 10 seconds."
        let shortSpeechInstruction = "Say Aaaaaaaaaaah for as long as you can."
        
        return ORKOrderedTask.audioTask(withIdentifier: "AudioTask", intendedUseDescription: intendedUseDescription, speechInstruction: speechInstruction, shortSpeechInstruction: shortSpeechInstruction, duration: 10, recordingSettings: nil, checkAudioLevel: false, options: ORKPredefinedTaskOption.excludeAccelerometer)
    }()
    
    static let tappingTask: ORKOrderedTask = {
        let intendedUseDescription = "Finger tapping is a universal way to communicate."
        
        return ORKOrderedTask.twoFingerTappingIntervalTask(withIdentifier: "TappingTask", intendedUseDescription: intendedUseDescription, duration: 10, handOptions: .both, options: ORKPredefinedTaskOption())
    }()
    
    static let surveyTask: ORKOrderedTask = {
        var steps = [ORKStep]()
        
        // Instruction step
        let instructionStep = ORKInstructionStep(identifier: "IntroStep")
        instructionStep.title = "Rare Bone Growth Chart Survey"
        instructionStep.text = "Please answer these 6 questions to the best of your ability. It's okay to skip a question if you don't know the answer."
        
        steps += [instructionStep]
        
        // Quest question using text choice
        let questQuestionStepTitle = "What is your gender?"
        let textChoices = [
            ORKTextChoice(text: "Male", value: 0 as NSCoding & NSCopying & NSObjectProtocol),
            ORKTextChoice(text: "Female", value: 1 as NSCoding & NSCopying & NSObjectProtocol)
//            ORKTextChoice(text: "Pluto", value: 2 as NSCoding & NSCopying & NSObjectProtocol),
//            ORKTextChoice(text: "Mars", value: 3 as NSCoding & NSCopying & NSObjectProtocol)
        ]
        let questAnswerFormat: ORKTextChoiceAnswerFormat = ORKAnswerFormat.choiceAnswerFormat(with: .singleChoice, textChoices: textChoices)
        let questQuestionStep = ORKQuestionStep(identifier: "TextChoiceQuestionStep", title: questQuestionStepTitle, answer: questAnswerFormat)
        
        steps += [questQuestionStep]
        
        // Name question using text input
        let nameAnswerFormat = ORKTextAnswerFormat(maximumLength: 25)
        nameAnswerFormat.multipleLines = false
        let nameQuestionStepTitle = "What is your diagnosis?"
        let nameQuestionStep = ORKQuestionStep(identifier: "NameQuestionStep", title: nameQuestionStepTitle, answer: nameAnswerFormat)
        
        steps += [nameQuestionStep]
        
//        let shapeQuestionStepTitle = "Which shape is the closest to the shape of Messier object 101?"
//        let shapeTuples = [
//            (UIImage(named: "square")!, "Square"),
//            (UIImage(named: "pinwheel")!, "Pinwheel"),
//            (UIImage(named: "pentagon")!, "Pentagon"),
//            (UIImage(named: "circle")!, "Circle")
//        ]
//        let imageChoices : [ORKImageChoice] = shapeTuples.map {
//            return ORKImageChoice(normalImage: $0.0, selectedImage: nil, text: $0.1, value: $0.1 as NSCoding & NSCopying & NSObjectProtocol)
//        }
//        let shapeAnswerFormat: ORKImageChoiceAnswerFormat = ORKAnswerFormat.choiceAnswerFormat(with: imageChoices)
//        let shapeQuestionStep = ORKQuestionStep(identifier: "ImageChoiceQuestionStep", title: shapeQuestionStepTitle, answer: shapeAnswerFormat)
//        
//        steps += [shapeQuestionStep]
        
        // Date question
        let today = NSDate()
        let dateAnswerFormat =  ORKAnswerFormat.dateAnswerFormat(withDefaultDate: today as Date, minimumDate: nil, maximumDate: today as Date, calendar: nil)
        let dateQuestionStepTitle = "When were you born?"
        let dateQuestionStep = ORKQuestionStep(identifier: "DateQuestionStep", title: dateQuestionStepTitle, answer: dateAnswerFormat)
        
        steps += [dateQuestionStep]
        
        // Boolean question
//        let booleanAnswerFormat = ORKBooleanAnswerFormat()
//        let booleanQuestionStepTitle = "Is Venus larger than Saturn?"
//        let booleanQuestionStep = ORKQuestionStep(identifier: "BooleanQuestionStep", title: booleanQuestionStepTitle, answer: booleanAnswerFormat)
//        
//        steps += [booleanQuestionStep]
        
        // Continuous question - tall
        let continuousAnswerFormat = ORKAnswerFormat.scale(withMaximumValue: 150, minimumValue: 20, defaultValue: 50, step: 10, vertical: false, maximumValueDescription: "cm", minimumValueDescription: " ")
        let continuousQuestionStepTitle = "How tall are you?"
        let continuousQuestionStep = ORKQuestionStep(identifier: "ContinuousQuestionStep", title: continuousQuestionStepTitle, answer: continuousAnswerFormat)
        steps += [continuousQuestionStep]
        
        // weight
        let continuousAnswerFormat1 = ORKAnswerFormat.scale(withMaximumValue: 150, minimumValue: 20, defaultValue: 50, step: 10, vertical: false, maximumValueDescription: "kg", minimumValueDescription: " ")
        let continuousQuestionStepTitle1 = "How much do you weight?"
        let continuousQuestionStep1 = ORKQuestionStep(identifier: "ContinuousQuestionStep1", title: continuousQuestionStepTitle1, answer: continuousAnswerFormat1)
        steps += [continuousQuestionStep1]
        
        
        
        // head
//        let continuousAnswerFormat2 = ORKAnswerFormat.scale(withMaximumValue: 150, minimumValue: 20, defaultValue: 50, step: 10, vertical: false, maximumValueDescription: "cm", minimumValueDescription: " ")
//        let continuousQuestionStepTitle2 = "What is your head circumference?"
//        let continuousQuestionStep2 = ORKQuestionStep(identifier: "ContinuousQuestionStep2", title: continuousQuestionStepTitle2, answer: continuousAnswerFormat2)
        
        
        
//        steps += [continuousQuestionStep2]
        
        let nameAnswerFormat2 = ORKTextAnswerFormat(maximumLength: 25)
        nameAnswerFormat2.multipleLines = false
        let nameQuestionStepTitle2 = "What is your head circumference (cm)?"
        let nameQuestionStep2 = ORKQuestionStep(identifier: "NameQuestionStep2", title: nameQuestionStepTitle2, answer: nameAnswerFormat2)
        steps += [nameQuestionStep2]
        
        // Summary step
        
        let summaryStep = ORKCompletionStep(identifier: "SummaryStep")
        summaryStep.title = "Thank you."
        summaryStep.text = "We appreciate your time."
        
        steps += [summaryStep]
        
        return ORKOrderedTask(identifier: "SurveyTask", steps: steps)
    }()
}
